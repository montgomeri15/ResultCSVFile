package org.example.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Directory {
    public static java.io.File createDirectory(String name) {
        try {
            return Files.createDirectory(Paths.get(name)).toFile();
        } catch (IOException e) {
            System.err.println("Can't create the directory bacause of " + e);
            return null;
        }
    }

    public static boolean directoryExists(String name){
        return Files.exists(Paths.get(name));
    }

    public static void deleteDirectory(String name) {
        Path path = Paths.get(name);
        if (Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (IOException e) {
                System.err.println("Directory doesn't exist: " + e);
            }
        }
    }
}
