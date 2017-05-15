package org.krynicki.ctci;

/**
 * Created by kamil.krynicki on 09/05/2017.
 */
public class Question4 {
    public static class BitMagic {
        public int nextSmallestSameOnes2(int in) {
            if (isMinValue(in))
                throw new IllegalArgumentException();

            int result = in;

            int zeros = countConsecutive(in, 0, 0);
            int ones = countConsecutive(in, 1, zeros);

            int mask = mask(ones + zeros);
            int mask2 = mask(ones - 1);

            result &= ~(mask - 1);
            result |= mask;
            result |= mask2 - 1;

            return result;
        }

        public int prvLargestSameOnes2(int in) {
            if (isMinValue(in) || isMaxValue(in))
                throw new IllegalArgumentException();

            int result = in;

            int ones = countConsecutive(in, 1, 0);
            int zeros = countConsecutive(in, 0, ones);

            int mask = mask(ones + zeros + 1);
            int mask2 = (mask(ones + 1) - 1) << zeros - 1;

            result &= ~(mask - 1);
            result |= mask2;

            return result;
        }

        private int mask(int i) {
            return 0b1 << i;
        }

        private boolean isMinValue(int in) {
            return in == 0;
        }

        private boolean isMaxValue(int in) {
            return ((in + 1) & in) == 0;
        }

        private int countConsecutive(int number, int value, int startIndex) {
            number = consume(number, startIndex);

            int result = 0;
            while (number > 0 && (number & 1) == value) {
                number >>>= 1;
                result++;
            }

            return result;
        }

        private int consume(int number, int bits) {
            int rewind = bits;
            while (rewind-- > 0) number >>>= 1;
            return number;
        }
    }
}
