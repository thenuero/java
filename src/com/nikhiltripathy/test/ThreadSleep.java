package com.nikhiltripathy.test;

public class ThreadSleep {

    public static void main(String args[]) {
        System.out.println("Main method called!");

        Thread t = new Thread(() -> {
            System.out.println("Before sleeping the thread.. " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
                System.out.println("After the sleep... " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
    }
}
