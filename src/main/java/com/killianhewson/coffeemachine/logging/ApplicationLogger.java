package com.killianhewson.coffeemachine.logging;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/** Provides application-level logging without exposing logger configuration to other classes. */
public final class ApplicationLogger {

    private static final Logger LOGGER = createLogger();

    private ApplicationLogger() {
    }

    private static Logger createLogger() {
        Logger logger = Logger.getLogger("CoffeeMachine");
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new SimpleFormatter());
        logger.setUseParentHandlers(false);
        logger.addHandler(handler);
        return logger;
    }

    public static void info(String message) {
        LOGGER.info(message);
    }

    public static void warning(String message, Exception exception) {
        if (exception == null) {
            LOGGER.warning(message);
        } else {
            LOGGER.log(Level.WARNING, message, exception);
        }
    }
}

