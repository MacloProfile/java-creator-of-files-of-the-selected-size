package com.example.languagetest;

import javafx.animation.FadeTransition;

import java.io.FileOutputStream;
import java.io.IOException;

public class AddSizeForFinalFile {
    //0 - the user didn't select the checkbox,1 - b, 2 - kb, 3 - mb
    private int unit;
    //file size in bytes
    private long fileSizeInBytes;
    private String filePath;
    //flag to check the correctness of the entered size
    private boolean flag = false;

    //file size in one of the selected units
    private long sizeOfFile;

    //constructor
    public AddSizeForFinalFile(String sizeOfFile, String filePath, int unit) {
        try {
            this.sizeOfFile = Integer.parseInt(sizeOfFile);
        } catch (Exception e) {
            flag = true;
        }
        this.filePath = filePath;
        this.unit = unit;
    }

    public void startAll() {
        if (unit == 0) {
            System.out.println("Select a checkbox");
        } else if (flag) {
            System.out.println("Incorrect file size");
        } else {
            setFileSizeInBytes(sizeOfFile);
            try {
                createFile(filePath, fileSizeInBytes);
                System.out.println("File was created successfully");
            } catch (Exception e) {
                System.out.println("File ERROR");
            }
        }
    }

    private static void createFile(String filePath, long fileSizeInBytes) throws IOException {
        //set random name
        int random = (int) (Math.random() * 100000);
        FileOutputStream fos = new FileOutputStream(filePath + "\\" + "file" + random + ".txt");
        //byte addition
        fos.write(new byte[(int) fileSizeInBytes]);
        fos.flush();
        fos.close();
    }

    private void setFileSizeInBytes(long sizeOfFile) {
        //translation if the user has selected units other than bytes
        switch (unit) {
            case (1):
                fileSizeInBytes = sizeOfFile;
                break;
            case (2):
                fileSizeInBytes = sizeOfFile * 1024;
                break;
            case (3):
                fileSizeInBytes = sizeOfFile * 1024 * 1024;
                break;
            default:
                //error case
                fileSizeInBytes = 1;
        }
    }
}
