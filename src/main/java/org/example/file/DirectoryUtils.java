package org.example.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryUtils {
    public static final Path pathForDir(String dirName){
        Path path = Paths.get(dirName);
        return path;
    }

    public static java.io.File createDir(String dirName) {
        try {
            return Files.createDirectory(pathForDir(dirName)).toFile();
        } catch (IOException e) {
            System.err.println(e);
            return null;
        }
    }

    public static boolean dirExists(String dirName) {
        return Files.exists(pathForDir(dirName));
    }

    public static void deleteDir(String dirName) {
        if(dirExists(dirName)) {
            try {
                Files.delete(pathForDir(dirName));
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}
