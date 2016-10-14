package com.apress.springenterpriserecipes.spring3.executors;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;

/**
 * This does nothing but take the input from the client and reply with the same
 * string, reversed.
 * 
 * Thus: 'hello' becomes 'olleh'
 * 
 * @author Josh Long
 */
public class SimpleReverseMain {
   private static Logger logger = Logger.getLogger(SimpleReverseMain.class
         .getName());

   public static void main(String[] args) throws Throwable {
      ReverseService networkService = new ReverseService(10);

      new Thread(new Runnable() {
         public void run() {
            try {
               Thread.sleep(TimeUnit.SECONDS.toMillis(2));
               // give our service time to start
            } catch (InterruptedException e) {
               // eat it
            }
            ReverseClient client = new ReverseClient();
            for (int i = 0; i < 10; i++) {
               String in = "Hello " + i;
               logger.info(String.format("Sent '%s', received '%s'", in, client
                     .reverse(in)));
            }
         }
      }).start();

      networkService.serve();
   }
}

class ServiceHandler implements Runnable {
   private final Socket socket;
   private UUID uuid;

   private static Logger logger = Logger.getLogger(ServiceHandler.class.getName());

   public ServiceHandler(Socket socket) {
      this.socket = socket;
      this.setUuid(UUID.randomUUID());
      logger.info("Creating handler " + this.uuid.toString());
   }

   public void setUuid(UUID uuid) {
      this.uuid = uuid;
   }

   public UUID getUuid() {
      return uuid;
   }

   public void run() {
      try {
         logger.info("Running handler " + this.uuid.toString());
         BufferedReader bufferedInputStreamReader = new BufferedReader(
               new InputStreamReader(socket.getInputStream()));
         PrintWriter bufferedPrintWriter = new PrintWriter(new BufferedWriter(
               new OutputStreamWriter(socket.getOutputStream())));
         String input = StringUtils.defaultString(
               bufferedInputStreamReader.readLine()).trim();
         bufferedPrintWriter.println(StringUtils.reverse(input));
         bufferedPrintWriter.flush();
      } catch (Throwable th) {
         logger.info(ExceptionUtils.getFullStackTrace(th));
      } finally {
         try {
            this.socket.close();
         } catch (IOException e) {
            // eat it
         }
      }
   }
}

class ReverseClient {
   private static final Logger logger = Logger.getLogger(ReverseClient.class
         .getName());
   private String host;
   private InetAddress address;

   public String reverse(String input) {
      String answer = null;
      try {
         this.address = InetAddress.getByName(host);
         Socket socket = new Socket(address,
               ReverseService.REVESE_NETWORK_SERVICE_PORT);
         try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket
                  .getInputStream()));
            PrintWriter writer = new PrintWriter(new BufferedWriter(
                  new OutputStreamWriter(socket.getOutputStream())));
            writer.println(input);
            writer.flush();
            answer = reader.readLine();

         } finally {
            socket.close();
         }
      } catch (IOException e) {
         logger.info(ExceptionUtils.getFullStackTrace(e));
      }
      return answer;
   }

}

class ReverseService {
   private static final Logger logger = Logger.getLogger(ReverseService.class
         .getName());
   public static int REVESE_NETWORK_SERVICE_PORT = 8020;
   private final ServerSocket serverSocket;
   private final ExecutorService pool;

   public ReverseService(int poolSize) throws IOException {
      serverSocket = new ServerSocket(REVESE_NETWORK_SERVICE_PORT);
      pool = Executors.newFixedThreadPool(poolSize);
   }

   public void serve() throws IOException {
      try {
         while (true)
            pool.execute(new ServiceHandler(serverSocket.accept()));

      } catch (IOException ex) {
         logger.info(ExceptionUtils.getFullStackTrace(ex));
         for (Runnable runnable : pool.shutdownNow()) {
            if (runnable instanceof ServiceHandler) {
               ServiceHandler sh = (ServiceHandler) runnable;
               logger.info("Could not execute handler " + sh.getUuid().toString());
            }
         }
      } finally {
         serverSocket.close();
         pool.shutdown();
      }
   }
}