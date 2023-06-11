package com.example.languagetest;

import javafx.animation.FadeTransition;

import java.io.FileOutputStream;
import java.io.IOException;

public class AddSizeForFinalFile {

    private String fileName = "";
    private String countOfCopies = "";

    //0 - the user didn't select the checkbox,1 - b, 2 - kb, 3 - mb, 4 - gb
    private int unit;
    private int count = 1;

    //file size in bytes
    private long fileSizeInBytes;
    private String filePath;

    //flag to check the correctness of the entered size
    public static boolean flag = false;

    //file size in one of the selected units
    private long sizeOfFile;

    //constructor
    public AddSizeForFinalFile(String sizeOfFile, String filePath, int unit, String fileName, String countOfCopies) {
        try {
            this.sizeOfFile = Integer.parseInt(sizeOfFile);
        } catch (Exception e) {
            flag = true;
        }
        this.filePath = filePath;
        this.unit = unit;
        this.fileName = fileName;
        this.countOfCopies = countOfCopies;
    }

    public String startAll() {
        //error check
        if (unit == 0) {
            return "Select a checkbox";
        } else if (flag) {
            return "Incorrect file size or number of files";

        } else {
            //set quantity of bytes
            Units units = new Units(sizeOfFile, unit);
            fileSizeInBytes = units.setFileSizeInBytes(sizeOfFile);
            //set number of files
            for (int i = 0; i < Copies.countCopies(countOfCopies); i++) {
                try {
                    createFile(filePath, fileSizeInBytes, fileName);
                } catch (Exception e) {
                    return "File creation error (most likely a problem with permissions to the folder)";
                }
            }
        }
        return "File was created successfully";
    }

    private void createFile(String filePath, long fileSizeInBytes, String fileName) throws IOException {
        //set random name
        if (fileName.equals("")) {
            int random = (int) (Math.random() * 100000);
            fileName = "file" + random + ".txt";
        } else if (Copies.countCopies(countOfCopies) > 1) {
            fileName = (int) (Math.random() * 1000) + fileName;
        }

        FileOutputStream fos = new FileOutputStream(filePath + "\\" + fileName);
        //byte addition
        if (unit == 4) {
            for (int i = 0; i < sizeOfFile; i++)
                fos.write(new byte[(int) fileSizeInBytes]);
        } else {
            fos.write(new byte[(int) fileSizeInBytes]);
        }
        fos.flush();
        fos.close();
    }
}
