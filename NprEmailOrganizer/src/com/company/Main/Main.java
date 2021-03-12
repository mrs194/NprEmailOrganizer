package com.company.Main;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        InputFile myFile = new InputFile();
        ArrayList<String> emailList;
        emailList = myFile.getList();

        ArrayList<String> validEmailList = new ArrayList<>();

        if (emailList.isEmpty()) {
            System.out.println("File is empty.");
        } else {
            //email address syntax check
            for (String e : emailList) {
                if (validateEmail(e)) {
                    validEmailList.add(e);
                }
            }

            int count = validEmailList.size();
            String[] orderedEmailList = new String[count];
            orderedEmailList = validEmailList.toArray(orderedEmailList);

            //Sort emails by domain name
            for (int i = 0; i < count; i++)
            {
                for (int j = i + 1; j < count; j++) {

                    String dom1 = orderedEmailList[i].
                            substring(orderedEmailList[i].
                                    lastIndexOf('@'));

                    String dom2 = orderedEmailList[j].
                            substring(orderedEmailList[j].
                                    lastIndexOf('@'));

                    if (dom1.compareTo(dom2)>0)
                    {
                        String temp = orderedEmailList[i];
                        orderedEmailList[i] = orderedEmailList[j];
                        orderedEmailList[j] = temp;
                    }
                }
            }

            //Output valid ordered list to the new file.
            OutputFile myNewFile = new OutputFile();
            myNewFile.populateFile(orderedEmailList);

        }
    }

    /**
     *
     * @param input the email to validate
     * @return is email valid
     * Using a Java Regular expression, create pattern and
     * compare with input
     */
    public static boolean validateEmail(String input) {
        if ((input.isEmpty()) ||
                (input.charAt(0) == '-' ) ||
                    (input.charAt(0) == '.') ||
                        (input.charAt(0) == '_' ||
                            (input.charAt(0) == '+' ||
                                (input.charAt(0) == ' ' ))))
        return false;

        String emailRegex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        Pattern emailPat = Pattern.compile(emailRegex,Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPat.matcher(input);
        return matcher.find();
    }
}
