package org.krynicki.ctci;

/**
 * Created by kamil.krynicki on 02/06/2017.
 */
public class Question5 {

    public int mul(int a, int b) {
        if(a == 0 || b == 0)
            return 0;

        return recursiveMul(Math.max(a, b), Math.min(a, b));
    }

    private int recursiveMul(int base, int mul) {
        if(mul == 1)
            return base;

        int result = recursiveMul(base, mul >> 1);

        return result + result + (isOdd(mul) ? base : 0);
    }

    private boolean isOdd(int value) {
        return (value & 1) == 1;
    }
}
