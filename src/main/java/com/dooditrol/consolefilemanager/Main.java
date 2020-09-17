package com.dooditrol.consolefilemanager;

public class Main {

    public static void printUsage() {

        System.out.println("Usage:"
                + "java -jar ConsoleFileManager.jar <file name> <key of operation> "
                + "\nkeys of operations:\n"
                + "\t-create\n\t\tcreate file\n"
                + "\t-remove\n\t\tremove file\n"
                + "\t-read\n\t\tprint file content\n"
                + "\t-write <line>\n\t\twrite a <line> to the file");
    }

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Wrong command:\n"
                    + "\tname file and key of operation not specified\n");
            printUsage();
        }
        else if (args.length == 1) {
            System.out.println("Wrong command:\n\tkey of operation not specified\n");
            printUsage();
        }
        else if (args.length == 2) {

            if (args[1].equalsIgnoreCase("-create")) {
                FileUtils.createFile(args[0]);
            }
            else if (args[1].equalsIgnoreCase("-remove")) {
                FileUtils.removeFile(args[0]);
            }
            else if (args[1].equalsIgnoreCase("-read")) {
                FileUtils.readFile(args[0]);
            }
            else if (args[1].equalsIgnoreCase("-write")) {
                System.out.println("Wrong command:\n\t-write need line");
            }
            else {
                System.out.println("Wrong command:\n\twrong key of operation\n");
                printUsage();
            }
        }
        else if (args[1].equalsIgnoreCase("-write") && args.length == 3) {
            FileUtils.writeFile(args[0], args[2]);
        }
        else {
            System.out.println("Wrong command:\n\textra arguments\n");
            printUsage();
        }
    }
}
