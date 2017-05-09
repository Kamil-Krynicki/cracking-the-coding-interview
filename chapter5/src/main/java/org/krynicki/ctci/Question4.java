package org.krynicki.ctci;

/**
 * Created by kamil.krynicki on 09/05/2017.
 */
public class Question4 {
    int nextSmallestSameOnes(int in) {
        char[] bits = Integer.toBinaryString(in).toCharArray();

        int i = oneToZeroIndex(bits);

        bits[i] = '1';
        bits[i + 1] = '0';

        return in;
    }

    private int oneToZeroIndex(char[] bits) {
        int i = bits.length - 1;

        while(bits[i] == '0') i--;
        while(bits[i] == '1') i--;

        return i;
    }
}
