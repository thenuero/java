package com.nikhiltripathy.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Locking {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(2);
        ReentrantLock lock = new ReentrantLock();

        es.submit(() ->{
            try {
            lock.lock();
            System.out.println("First task...");
            Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        });

        es.submit(() -> {
            try {
                System.out.println("Before requesting for lock.. 2nd task");
                //lock.lock();
                lock.tryLock();
                System.out.println("Got the lock");
            } finally {
                lock.unlock();
            }
        });

        es.shutdown();
        es.awaitTermination(3, TimeUnit.SECONDS);
    }
}
