package org.example.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DirectoryUtils {
    public static java.io.File createDir(String dirName) {
        try {
            return Files.createDirectory(Paths.get(dirName)).toFile();
        } catch (IOException e) {
            System.err.println(e);
            return null;
        }
    }

    public static void deleteDir(String dirName) {
        try {
            Files.deleteIfExists(Paths.get(dirName));
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
