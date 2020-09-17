package com.dooditrol.consolefilemanager;

import java.io.*;

public class FileUtils {

    public static void createFile(String fileName) {
        File file = new File(fileName);

        if (isCorrectNewFilePath(file)) {
            try {
                if (file.createNewFile()) {
                    System.out.println("File was created successfully");
                }
                else {
                    System.err.println("Error: file already exists");
                }
            } catch (IOException ex) {
                System.err.println("I/O error occurred when creating file");
            }
        }
    }

    public static void removeFile(String fileName) {
        File file = new File(fileName);

        if (isCorrectFile(file)) {

            if (file.delete()) {
                System.out.println("File was removed successfully");
            }
            else {
                System.err.println("Error when deleting file");
            }
        }
    }

    public static void readFile(String fileName) {
        File file = new File(fileName);

        if (isCorrectFile(file)) {

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                System.out.println("File contents:");
                String str;

                while ((str = br.readLine()) != null) {
                    System.out.println(str);
                }
            }
            catch (FileNotFoundException  ex) {
                System.err.println("Error: file cannot be opened for reading");
            }
            catch (IOException ex) {
                System.err.println("Error: I/O error occurred when reading file");
            }
        }
    }

    public static void writeFile(String fileName, String str) {
        File file = new File(fileName);

        if (isCorrectFile(file)) {

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
                bw.write(str);
            }
            catch (IOException ex) {
                System.err.println("Error: I/O error occurred when writing string to file");
            }
            System.out.println("String was written successful to file");
        }
    }

    private static boolean isCorrectNewFilePath(File file) {

        if (!file.isAbsolute()) {
            System.err.println("Error: " + file + " is not absolute path");
            return false;
        }
        //file = file.getAbsoluteFile();
        File parentDirectory = file.getParentFile();

        if (parentDirectory.exists()) {
            return true;
        }
        else {
            System.err.println("Error: " + parentDirectory + " directory is not exists");
            return false;
        }
    }

    private static boolean isCorrectFile(File file) {

        if (!file.isAbsolute()) {
            System.err.println("Error: " + file + " is not absolute path");
            return false;
        }

        if (file.exists()) {

            if (file.isFile()) {
                return true;
            }
            else {
                System.err.println("Error: " + file.getName() + " is not file");
                return false;
            }
        }
        else {
            System.err.println("Error: " + file.getName() + " is not exists");
            return false;
        }
    }
}
