package org.example.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {
    public static final Path pathForFile(String dirName, String fileName){
        Path path = Paths.get(dirName, fileName);
        return path;
    }

    public static java.io.File createFile(String dirName, String fileName) {
        try {
            return Files.createFile(pathForFile(dirName, fileName)).toFile();
        } catch (IOException e) {
            System.err.println(e);
            return null;
        }
    }

    public static boolean fileExists(String dirName, String fileName) {
        return Files.exists(pathForFile(dirName, fileName));
    }

    public static void deleteFile(String dirName, String fileName) {
        if (fileExists(dirName, fileName)){
            try {
                Files.delete(pathForFile(dirName, fileName));
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}
