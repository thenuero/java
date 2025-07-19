package com.nikhiltripathy.test;

import java.util.concurrent.*;

public class CallableTest {

    public static void main(String args[]) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(1);

        Future f = es.submit(() ->
             1234
        );
        Thread.sleep(1000);
        System.out.println(f.isDone());
        System.out.println(f.get());
        es.shutdown();
    }
}
