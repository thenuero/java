package com.nikhiltripathy.files;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccess {
    public static void main(String[] args) {
        try (RandomAccessFile ra = new RandomAccessFile("/Users/nikhiltripathy/Downloads/sample1.txt","r")) {
           // ra.seek(ra.length()-10);
            ra.seek(0);
            byte[] bytes = new byte[100];
            //ra.readLine();

            //System.out.println(new String(bytes));
            System.out.println(ra.readLine());
            ra.close();


        } catch (IOException e) {
            System.out.println("IO exception caught..");
            e.printStackTrace();
        }

    }
}
