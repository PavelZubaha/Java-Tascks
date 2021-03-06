package com.pzubaha.logger;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 1. Create a bean to configure the parent logger and console handler
 *
 * 2. Configure the bean in the Spring XML config file
 *
 * Detailed Steps
 *
 * 1. Create a bean to configure the parent logger and console handler
 *
 * This class will set the parent logger level for the application context.
 * It will also set the logging level for console handler.
 * It sets the logger level to FINE. For more detailed logging info,
 * you can set the logging level to level to FINEST.
 * You can read more about the logging levels at
 * http://www.vogella.com/tutorials/Logging/article.html
 *
 * This class also has an init method to handle the actual configuration.
 * The init method is executed after the bean has been created and dependencies injected.
 */
public class MyLoggerConfig {

    private String rootLoggerLevel;
    private String printedLoggerLevel;

    public void setRootLoggerLevel(String rootLoggerLevel) {
        this.rootLoggerLevel = rootLoggerLevel;
    }

    public void setPrintedLoggerLevel(String printedLoggerLevel) {
        this.printedLoggerLevel = printedLoggerLevel;
    }

    public void initLogger() {

        // parse levels
        Level rootLevel = Level.parse(rootLoggerLevel);
        Level printedLevel = Level.parse(printedLoggerLevel);

        // get logger for app context
        Logger applicationContextLogger = Logger.getLogger(AnnotationConfigApplicationContext.class.getName());

        // get parent logger
        Logger loggerParent = applicationContextLogger.getParent();

        // set root logging level
        loggerParent.setLevel(rootLevel);

        // set up console handler
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(printedLevel);
        consoleHandler.setFormatter(new SimpleFormatter());

        // add handler to the logger
        loggerParent.addHandler(consoleHandler);
    }

}