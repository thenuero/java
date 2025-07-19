package com.nikhiltripathy.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class AtomicClasses {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger at = new AtomicInteger(0);

        ExecutorService es = Executors.newFixedThreadPool(2);

        IntStream.range(0,100)
                .forEach(i -> es.submit(at::incrementAndGet));

        es.shutdown();
        es.awaitTermination(2, TimeUnit.SECONDS);
        System.out.println(at);
    }
}
