package com.company.Main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OutputFile {

    public OutputFile(){

        try {
            File myNewFile = new File("Results.txt");
            if (myNewFile.createNewFile()) {
                System.out.println("File created: " + myNewFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException q) {
            System.out.println("An error occurred.");
            q.printStackTrace();
        }
    }

    /**
     * @param list finalized list of valid and organized email addresses
     */
    public void populateFile(String[] list) {

        try {
            FileWriter myWriter = new FileWriter("Results.txt");
            for (String email : list) {
                myWriter.write(email + "\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file");

        } catch (IOException q) {
            System.out.println("An error occurred.");
            q.printStackTrace();
        }
    }
}
