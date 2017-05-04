package org.krynicki.ctci;

/**
 * Created by kamil.krynicki on 04/05/2017.
 */
public class Question1 {
    public byte replace(byte in, byte with, int i, int j) {
        byte mask = (byte) 0xFF;
        mask = (byte) (mask << j);
        mask = (byte) (mask >> (j - i));
        mask = (byte) ~mask;

        return (byte) (in * mask + (with << i));
    }
}
