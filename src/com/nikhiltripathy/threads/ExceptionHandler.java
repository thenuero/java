package com.nikhiltripathy.threads;

public class ExceptionHandler {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            int res = 2/0;
            System.out.println("I'm new thread");
        });

        thread.setUncaughtExceptionHandler((t, e) -> {
            System.out.println(t.getName());
            e.printStackTrace();
            System.out.println("Exception caught....");
        });
        thread.start();
    }
}
