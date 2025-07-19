package com.nikhiltripathy.lambdas;

public class MathTest {

    public void performOps(int a, int b, MathOps ops) {
        System.out.println(ops.operations(a,b));
    }

    public static void main(String args[]) {
        MathTest test = new MathTest();
        System.out.println("Performing addition... ");
        //naive syntax for me...
        test.performOps(8,9,
                ( x, y) -> {
            return x+y;
                });
        System.out.println("Performing substraction... ");
        //Even better syntax..
        test.performOps(3,4, (x,y) ->
             x - y
        );

        System.out.println("Performing division... ");
        test.performOps(20, 4 ,
                (x,y) -> x/y
    );
    }
}
