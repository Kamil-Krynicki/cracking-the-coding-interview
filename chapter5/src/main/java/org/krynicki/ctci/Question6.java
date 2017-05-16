package org.krynicki.ctci;

/**
 * Created by kamil.krynicki on 16/05/2017.
 */
public class Question6 {
    int flipDistance(int from, int to) {
        return Integer.bitCount(from ^ to);
    }
}
