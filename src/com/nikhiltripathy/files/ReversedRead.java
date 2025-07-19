package com.nikhiltripathy.files;

//import org.apache.commons.io.input.ReversedLinesFileReader;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

//public class ReversedRead {
//    public static void main(String[] args) {
//        try (ReversedLinesFileReader reader = new ReversedLinesFileReader(new File("/Users/nikhiltripathy/Downloads/sample1.txt"), StandardCharsets.UTF_8)) {
//            List<String> lines = new ArrayList<>();
//            String line = "";
//            while ((line = reader.readLine()) != null && lines.size() < 3) {
//                lines.add(line);
//                //System.out.println(line);
//            }
//
//            lines.stream()
//                    .forEach(System.out::println);
//        } catch (IOException e) {
//            System.out.println("IO exception occured..");
//            e.printStackTrace();
//        }
//    }
//}
