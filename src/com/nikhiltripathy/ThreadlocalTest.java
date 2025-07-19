package com.nikhiltripathy;

import javax.swing.plaf.TableHeaderUI;

public class ThreadlocalTest {

    public static void main(String args[]) {

        ThreadLocal<String> mylocal = new ThreadLocal<>();

        Thread t = new Thread(() -> {
            mylocal.set("first thread " + Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("thread interupted");
            }
            System.out.println(Thread.currentThread().getName() + mylocal.get());
        });
        Thread t2 = new Thread(() -> {
            mylocal.set("second thread" + Thread.currentThread().getName());
            try {
                Thread.sleep(100);

            }catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + mylocal.get());
            }
            System.out.println(Thread.currentThread().getName() + mylocal.get());
        });

        t.start();
        t2.start();
    }
}
