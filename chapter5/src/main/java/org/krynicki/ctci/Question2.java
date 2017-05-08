package org.krynicki.ctci;

/**
 * Created by kamil.krynicki on 08/05/2017.
 */
public class Question2 {
    private final int MAX_BITS = 32;
    String toBits(double in) {
        char[] result = new char[MAX_BITS];
        int bits = 0;

        double factor = 1f;
        double remaining = in;

        while(remaining > 0) {
            if (isOverflow(bits)) {
                return "Error";
            }

            factor /= 2;

            if (remaining < factor) {
                result[bits] = '0';
            } else {
                result[bits] = '1';
                remaining -= factor;
            }

            bits++;
        }

        return "0."+(new String(result).substring(0, bits));
    }

    private boolean isOverflow(int bits) {
        return bits >= MAX_BITS;
    }
}
