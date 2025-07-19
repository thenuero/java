package com.nikhiltripathy.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SyncMain {

    public static void main(String[] args) throws InterruptedException {
        SynchronisedTest st = new SynchronisedTest();

        ExecutorService es = Executors.newFixedThreadPool(2);

        es.submit(() -> {
            try {
                st.printSomething();
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        });

        es.submit(() -> {
            st.printName();
        });

        es.shutdown();
        es.awaitTermination(2, TimeUnit.SECONDS);
    }
}
