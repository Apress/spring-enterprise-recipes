package com.apress.springenterpriserecipes.spring3.executors;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.SyncTaskExecutor;
import org.springframework.core.task.support.TaskExecutorAdapter;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.timer.TimerTaskExecutor;

public class SpringExecutorsDemo {

   public static void main(String[] args) {
      ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
            "context2.xml");
      SpringExecutorsDemo demo = ctx.getBean("springExecutorsDemo",
            SpringExecutorsDemo.class);
      demo.submitJobs();
   }

   @Autowired
   private SimpleAsyncTaskExecutor asyncTaskExecutor;

   @Autowired
   private SyncTaskExecutor syncTaskExecutor;

   @Autowired
   private TaskExecutorAdapter taskExecutorAdapter;

   /*
    * @Resource(name = "timerTaskExecutorWithScheduledTimerTasks") private
    * TimerTaskExecutor timerTaskExecutorWithScheduledTimerTasks;
    */

   @Resource(name = "timerTaskExecutorWithoutScheduledTimerTasks")
   private TimerTaskExecutor timerTaskExecutorWithoutScheduledTimerTasks;

   @Autowired
   private ThreadPoolTaskExecutor threadPoolTaskExecutor;

   @Autowired
   private DemonstrationRunnable task;

   public void submitJobs() {
      syncTaskExecutor.execute(task);
      taskExecutorAdapter.submit(task);
      asyncTaskExecutor.submit(task);
      timerTaskExecutorWithoutScheduledTimerTasks.submit(task);

      /*
       * will do 100 at a time, then queue the rest, ie, should take round 5
       * seconds total
       */
      for (int i = 0; i < 500; i++)
         threadPoolTaskExecutor.submit(task);

   }
}
