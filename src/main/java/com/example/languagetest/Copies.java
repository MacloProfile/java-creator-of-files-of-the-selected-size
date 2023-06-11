package com.example.languagetest;

public class Copies {
    //set the number of files
    public static int countCopies(String countOfCopies) {
        int copies = 1;
        if (countOfCopies.equals(""))
            return copies;
        try {
            copies = Integer.parseInt(countOfCopies);
        } catch (Exception e) {
            AddSizeForFinalFile.flag = true;
        }
        return copies;
    }
}
