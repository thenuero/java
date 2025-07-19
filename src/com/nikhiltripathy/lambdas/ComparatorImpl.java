package com.nikhiltripathy.lambdas;

public class ComparatorImpl {

    public boolean testCompare(int a, int b, MyComparator comp) {
        return comp.compare(a,b);
    }

    public static void main(String args[]) {
        ComparatorImpl cmimpl = new ComparatorImpl();
        System.out.println(cmimpl.testCompare(4,5, (a,b) -> a <b));
    }
}
