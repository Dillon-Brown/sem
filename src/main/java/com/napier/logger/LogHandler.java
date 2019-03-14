package com.napier.logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LogHandler {
    private static final LogManager logManager = LogManager.getLogManager();
    private static final Logger LOGGER = Logger.getLogger(LogManager.class.getName());

    public static void main(String[] args) throws IOException {
        FileHandler logFile;
        String logFileName = "./semLog.log";
        try {
            logManager.readConfiguration(new FileInputStream("src/main/java/com/napier/logger/logger.properties"));
            logFile = new FileHandler(logFileName);
            LOGGER.addHandler(logFile);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "FileHandler Error: ", e);
            throw new IOException(e.getMessage());
        }
    }
}
