package org.krynicki.ctci;

/**
 * Created by kamil.krynicki on 09/05/2017.
 */
public class Question4 {
    public static class BitMagic {
        public int nextSmallestSameOnes(int in) {
            if (isMinValue(in))
                throw new IllegalArgumentException();

            int result = in;
            int i = findFlipIndex(result, 0, 1);

            result ^= mask(i - 1);

            return result;
        }

        public int prvLargestSameOnes(int in) {
            if (isMinValue(in) || isMaxValue(in))
                throw new IllegalArgumentException();

            int result = in;
            int i = findFlipIndex(result, 1, 0);

            result ^= mask(i - 1);

            return result;
        }

        private boolean isMinValue(int in) {
            return in == 0;
        }

        private boolean isMaxValue(int in) {
            return ((in + 1) & in) == 0;
        }

        private int findFlipIndex(int bits, int flipFrom, int flipTo) {
            int i = 0;

            while (bits > 0 && (bits & 1) == flipFrom) {
                bits >>>= 1;
                i++;
            }

            while (bits > 0 && (bits & 1) == flipTo) {
                bits >>>= 1;
                i++;
            }

            return i;
        }

        private int mask(int i) {
            return 0b11 << i;
        }
    }
}
