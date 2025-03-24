package com.hussein.chat.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class ChatLogService {
    private static final String LOG_DIR = "chat-logs";
    private static final String LOG_FILE = "public.txt";
    private final Path logFilePath;

    public ChatLogService() {
        // Create directory if it doesn't exist
        Path logDirPath = Paths.get(LOG_DIR);
        try {
            if (!Files.exists(logDirPath)) {
                Files.createDirectories(logDirPath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Set the path for our chat log file
        logFilePath = Paths.get(LOG_DIR, LOG_FILE);
        // Ensure the file exists
        try {
            if (!Files.exists(logFilePath)) {
                Files.createFile(logFilePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Append a new message to the log file
    public void logMessage(String message) {
        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String logEntry = message + " "+ System.lineSeparator();
        try {
            Files.write(logFilePath, logEntry.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read and return the full chat log
    public String getChatLog() {
        try {
            return new String(Files.readAllBytes(logFilePath));
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
