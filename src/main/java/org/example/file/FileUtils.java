package org.example.file;

import org.example.person.incomingdata.Person;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileUtils {
    public static java.io.File createFile(String dirName, String fileName) {
        try {
            return Files.createFile(Paths.get(dirName, fileName)).toFile();
        } catch (IOException e) {
            System.err.println(e);
            return null;
        }
    }

    public static void deleteFile(String dirName, String fileName) {
        try {
            Files.deleteIfExists(Paths.get(dirName, fileName));
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static void writeToCSVFile(String dirName, String fileName, List<Person> personsToFile) {
        for(Person person : personsToFile) {
            try {
                Files.write(Paths.get(dirName, fileName), person.personsListInBytes(),
                        //For adding, not rewriting
                        StandardOpenOption.APPEND);
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}
