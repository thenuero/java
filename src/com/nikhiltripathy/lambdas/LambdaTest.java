package com.nikhiltripathy.lambdas;

public class LambdaTest {

    public static void main(String args[]) {
        Thread t = new Thread (() -> {
            System.out.println("Fuck you bitches...");
        });
        t.start();
    }
}
