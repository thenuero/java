package com.nikhiltripathy.threads;

public class VirtualThread {
    public static void main(String[] args) {
        System.out.println("Test");
        for (int i=0;i<5;i++) {
            Thread.startVirtualThread(() -> System.out.println("Running in virtual thread. " + Thread.currentThread().getName()));
        }
    }
}
