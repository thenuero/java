package com.nikhiltripathy.threads;

import java.io.*;

public class FileReading {

    public static void main(String[] args) {
        System.out.println("Main method");
        Thread thread = new Thread(() -> {
            System.out.println("Starting thread");
            File file = new File("/Users/nikhiltripathy/Downloads/samplead.txt");

            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String st;
                while ((st = br.readLine()) != null) {
                    System.out.println(st);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        thread.setUncaughtExceptionHandler((t,e) ->
                System.out.println("custom error handler " +e.getMessage())
        );
        thread.start();
    }
}
