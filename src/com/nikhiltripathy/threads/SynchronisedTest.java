package com.nikhiltripathy.threads;

import java.util.concurrent.locks.ReentrantLock;

public class SynchronisedTest {

    public void printSomething() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        try {
        Thread.sleep(2000);
        System.out.println("Printing something");
        } finally {
            lock.unlock();
        }
    }

    public void printName() {
        ReentrantLock lock = new ReentrantLock();
        try {
            lock.lock();
        System.out.println("Nikhil");
        } finally {
            lock.unlock();
        }
    }
}
