package org.krynicki.ctci;

/**
 * Created by kamil.krynicki on 16/05/2017.
 */
public class Question7 {
    private final static int MASK = 0xaaaaaaaa;

    int pairwiseSwap(int in) {
        return ( in & MASK >>> 1) | (in & (MASK >>> 1) << 1);
    }
}
