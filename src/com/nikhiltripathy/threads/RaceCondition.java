package com.nikhiltripathy.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class RaceCondition {

    public static int counter = 0;

    synchronized static void increment() {
        counter = counter+1;
    }

    static void asyncIncrement() {
        counter++;
    }

    public static void main(String args[]) throws InterruptedException {
        testAsyncInc();
        testSyncInc();

    }

    private static void testSyncInc() throws InterruptedException {
        counter = 0;
        ExecutorService es = Executors.newFixedThreadPool(2);

        IntStream.range(0,1000)
                .forEach(i -> {
                    es.submit(RaceCondition::increment);
                });

        es.shutdown();
        boolean b = es.awaitTermination(60, TimeUnit.SECONDS);
        System.out.println("Sync counter " + counter);
    }

    private static void testAsyncInc() throws InterruptedException {
        counter = 0;
        ExecutorService es = Executors.newFixedThreadPool(2);

        IntStream.range(0,1000)
                .forEach(i -> {
                    es.submit(RaceCondition::asyncIncrement);
                });

        es.shutdown();
        boolean b = es.awaitTermination(60, TimeUnit.SECONDS);
        System.out.println("Async counter "+ counter);
    }
}
