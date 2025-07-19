package com.nikhiltripathy.threads;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;

public class MyThreadTest {

    @SuppressWarnings("all")
    public static void main(String[] args) throws InterruptedException {
        //check if the file exists..
        //Path path = Paths.get("/Users/nikhiltripathy/testlog");

        Thread t = new Thread(() -> {
            FileWriter fw = null;
            BufferedWriter writer = null;
            File logfile = new File("/Users/nikhiltripathy/testlog/log.txt");
                try {
                    if (!logfile.exists()) {
                        logfile.createNewFile();
                    }
                    fw = new FileWriter(logfile,true);
                    writer = new BufferedWriter(fw);
                } catch (IOException e) {
                    e.printStackTrace();
                }



                try {
                    while(!Thread.currentThread().isInterrupted()) {
                        Thread.sleep(1000);
                        System.out.println("writing to file...");
                        writer.write("Thread is writing to file: " + new Timestamp(System.currentTimeMillis()) + "\r");
                        writer.flush();
                    }
                    System.out.println("closing....");

                } catch (IOException | InterruptedException e) {
                    System.out.println("Issue with writing to the file...");
                    e.printStackTrace();
                } finally {
                    System.out.println("closing connections....");
                    try {
                        writer.close();
                        fw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
        });
        t.start();
        Thread.sleep(3000);
        t.interrupt();

    }
}
