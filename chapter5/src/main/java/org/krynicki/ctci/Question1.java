package org.krynicki.ctci;

/**
 * Created by kamil.krynicki on 04/05/2017.
 */
public class Question1 {
    public int replace(int in, int with, int i, int j) {
        int mask = 0xFFFFFFF;
        mask = (mask << j);
        mask = (mask >> (j - i));
        mask = ~mask;

        return (in * mask + (with << i));
    }
}
