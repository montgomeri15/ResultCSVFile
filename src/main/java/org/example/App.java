package org.example;

import org.example.file.DirectoryUtils;
import org.example.file.FileUtils;
import org.example.person.ListOfPersons;

public class App {
    public static void main( String[] args ) {
        String dirName = "output";
        String fileName = "result.csv";

        DirectoryUtils.createDir(dirName);
        FileUtils.createFile(dirName, fileName);
        FileUtils.writeToCSVFile(dirName, fileName, ListOfPersons.listOfPersons());
    }
}
