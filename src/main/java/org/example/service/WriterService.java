package org.example.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriterService {

    private final FileWriter fileWriter;

    public WriterService(String outputDestination) {
        Path fileOutputPath = Paths.get(outputDestination);
        File fileOutput = fileOutputPath.toFile();

        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(fileOutput);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        this.fileWriter = fileWriter;
    }

    public void write(String message) {
        try {
            fileWriter.write(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() {
        try {
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
