package com.nikhiltripathy.designpattern;

public class Singleton {

    private static Singleton singleton;

    //Eager init
    //private static Singleton eagerSingleton = new Singleton();


    //static block initialization for exception handling.. better the eager.
//    static {
//        try {
//            singleton = new Singleton();
//        } catch (RuntimeException e) {
//            System.out.println("Fucking exception caught");
//        }
//    }

    private Singleton() {

    }

    //Static for obvious reasons.. will be called by class directly.
    //this is lazy init.
    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    public static synchronized Singleton getInstanceTSafe() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    //Double checked safety

    public static Singleton getInstanceDoubleChecked() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                singleton = new Singleton();
            }
        }
        return singleton;
    }
}
