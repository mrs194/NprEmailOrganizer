package com.company.Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Find and read emails from the input file.
 */
public class InputFile {

    ArrayList<String> domainList = new ArrayList<>();

    public InputFile() {

        try {
            File myFile = new File("EmailList.txt");
            Scanner myReader = new Scanner(myFile);

            while (myReader.hasNextLine()) {
                String email = myReader.nextLine();
                domainList.add(email);
            }
            myReader.close();

        } catch (FileNotFoundException q) {
            System.out.println("An error occurred.");
            q.printStackTrace();
        }
    }

    //Get list of input emails
    public ArrayList<String> getList() {
        return domainList;
    }
}
