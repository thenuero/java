package com.nikhiltripathy.test;

public class GenericDisplay {

    public static  <T> void display(T element[]) {
        System.out.println(element);
    }

    public static void main(String[] args) {
        //display(10);
        //display("Nikhil");
    }
}
