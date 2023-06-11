package com.example.languagetest;

public class Units {
    private long size;
    private int unit;

    public Units(long size, int unit) {
        this.size = size;
        this.unit = unit;
    }

    public long setFileSizeInBytes(long sizeOfFile) {
        //translation if the user has selected units other than bytes
        switch (unit) {
            case (1):
                return sizeOfFile;
            case (2):
                return sizeOfFile * 1024;
            case (3):
                return sizeOfFile * 1024 * 1024;
            case (4):
                return 1024 * 1024 * 1024;
            default:
                //error case
                return  1;
        }
    }
}
