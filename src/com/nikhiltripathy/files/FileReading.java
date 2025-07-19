package com.nikhiltripathy.files;

import java.io.File;
import java.io.FileWriter;
import java.sql.Timestamp;

public class FileReading {

    public static void main(String[] args) throws Exception {

        File logFile = new File("/Users/nikhiltripathy/testlog/main.txt");
        FileWriter fw = new FileWriter(logFile, true);
        for (int i=0;i<10;i++) {
            fw.write("thread on work.." + new Timestamp(System.currentTimeMillis()) + "\r");
        }
        fw.write("end of session");
        fw.close();
    }
}
