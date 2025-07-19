package com.nikhiltripathy.lambdas;

public class TestSam {

    public static void main(String args[]) {
        LambdaImpl impl = new LambdaImpl();
        //aam zindagi
//        impl.lambdaConsumer(new MySam() {
//            @Override
//            public void doSomething(String a, String b) {
//                System.out.print("Did it...");
//            }
//        });

        //Mentos zindagi
        LambdaImpl impl2 = new LambdaImpl();
        //implementation of the sam is provided here...
        impl2.lambdaConsumer("Nikhil", "Tripathy",
                (a,b) -> System.out.println(a+" "+b+" Mentos zindagi..")
                );
    }
}
