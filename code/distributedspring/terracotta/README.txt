How to run these examples:

the manual way (using the dso-env.sh and so on) works fine for production. However, during development there are plenty of btter options, not the least of which is the Maven Terracotta plugin.

To run the examples you need only change the configuration file that's used and then run the server and then as many clients as you want.

This looks like:

 mvn -Dtcconfig=tc-customerconsole-wo-spring.xml tc:start

Which starts the server for you.

Finally,
 mvn -Dtcconfig=tc-customerconsole-wo-spring.xml tc:run runs a client node. You can modify the POM for more specific behavior. Additionally, you may start as many of theses clients as you'd like.


