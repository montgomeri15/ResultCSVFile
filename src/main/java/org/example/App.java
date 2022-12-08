package org.example;

import org.example.file.DirectoryUtils;
import org.example.file.FileUtils;

public class App {
    public static void main( String[] args ) {
        String dirName = "output";
        String fileName = "result.csv";

        DirectoryUtils.createDir(dirName);
        FileUtils.createFile(dirName, fileName);
    }
}
