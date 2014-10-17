package fr.inria.diverse.noveltytesting.samples;

/**
 * Created by leiko on 17/10/14.
 */
public class FooClass {

    public void print(int val) {
        System.out.println("Output: "+val);
    }

    public boolean isPositive(double a) {
        return a > 0;
    }

    public String concat(String a, String b) {
        return a + b;
    }

    public long sum(int a) {
        if (a < 0) {
            return 0;
        } else if (a > 500000) {
            return Integer.MAX_VALUE;
        } else {
            return sum(a - 1) + a;
        }
    }

    public boolean inverse(boolean b) {
        return !b;
    }
}
