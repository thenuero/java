package com.nikhiltripathy.files;

import java.io.File;
import java.util.Arrays;

/**
 * Created on 30/08/2025 at 09:28
 * Author: theneuro
 */

public class FileFilter {

    public static void main(String[] args) {
        String filename = "/Users/nikhiltripathy/Projects/Chat-Application";

        File[] directories = getDirectories(filename);
        Arrays.stream(directories).forEach(FileFilter::printFileName);

    }

    private static File[] getDirectories (String filename) {
        File file = new File(filename);

        //return file.listFiles((filfilter) -> filfilter.isDirectory());
        return file.listFiles(File::isDirectory);
    }

    private static void printFileName(File file) {
        System.out.println(file.getName());
    }
}
