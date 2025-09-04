package com.nikhiltripathy.lambdas;

/**
 * Created on 28/08/2025 at 13:07
 * Author: theneuro
 */

public class IllegalLambda {

    private static void repeatMessage(int count, String message) {
        //Block of code is illegal.
//        Runnable runnable = () -> {
//            while(count > 0) {
//                System.out.println(message);
//                count--;
//            }
//        };

        //This is legal. Free variables cannot be updated. Thread safety.
        Runnable runnable = () -> {
            for (int i=0;i<count;i++) {
                System.out.println(message);
                Thread.yield();
            }
        };
        new Thread(runnable).start();
    }

    public static void main(String[] args) {
        repeatMessage(100, "Hello Nikhil");
    }
}
