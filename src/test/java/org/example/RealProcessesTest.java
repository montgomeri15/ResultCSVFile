package org.example;

import org.example.file.DirectoryUtils;
import org.example.file.FileUtils;
import org.example.person.incomingdata.Person;
import org.example.person.incomingdata.Sex;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RealProcessesTest {

    @Disabled("Disabled until needed because of creating real directories.")
    @Test
    @DisplayName("Directory is created")
    void testDirectoryCreating() {
        String dirName = "dir";

        DirectoryUtils.createDir(dirName);

        assertThat(Files.exists(Paths.get(dirName))).isTrue();
    }

    @Disabled("Disabled until needed because of deleting real directories.")
    @Test
    @DisplayName("Directory is deleted")
    void testDirectoryDeleting() {
        String dirName = "dir";

        DirectoryUtils.createDir(dirName);
        DirectoryUtils.deleteDir(dirName);

        assertThat(Files.exists(Paths.get(dirName))).isFalse();
    }

    @Disabled("Disabled until needed because of creating real files.")
    @Test
    @DisplayName("File is created")
    void testFileCreating() {
        String dirName = "dir";
        String fileName = "file.txt";

        DirectoryUtils.createDir(dirName);
        FileUtils.createFile(dirName, fileName);

        assertThat(Files.exists(Paths.get(dirName, fileName))).isTrue();
    }

    @Disabled("Disabled until needed because of deleting real files.")
    @Test
    @DisplayName("File is deleted")
    void testFileDeleting() {
        String dirName = "dir";
        String fileName = "file.txt";

        FileUtils.deleteFile(dirName, fileName);

        assertThat(Files.exists(Paths.get(dirName, fileName))).isFalse();
    }

    @Disabled("Disabled until needed because of adding a list to the real file.")
    @Test
    @DisplayName("List is added to CSV")
    void testCorrectAddedListToCSV() throws IOException {
        String dirName = "dir";
        String fileName = "file.csv";
        Path path = Paths.get(dirName, fileName);
        List<Person> testPersons = List.of(
                new Person("Pamela", 26, Sex.FEMALE),
                new Person("Angela", 30, Sex.FEMALE),
                new Person("Phyllis", 56, Sex.FEMALE),
                new Person("Jazz", 13, Sex.FEMALE)
        );

        DirectoryUtils.createDir(dirName);
        FileUtils.createFile(dirName, fileName);
        FileUtils.writeToCSVFile(dirName, fileName, testPersons);

        assertThat(Files.exists(path)).isTrue();
        assertThat(Files.readAllLines(path).contains(
                        "Pamela,\t26,\tFEMALE\n" +
                        "Angela,\t30,\tFEMALE\n" +
                        "Phyllis,\t56,\tFEMALE\n" +
                        "Jazz,\t13,\tFEMALE"
        ));
    }
}
