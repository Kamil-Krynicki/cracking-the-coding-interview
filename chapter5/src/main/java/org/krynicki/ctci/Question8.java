package org.krynicki.ctci;

/**
 * Created by kamil.krynicki on 16/05/2017.
 */
public class Question8 {
    static class Screen {
        public static final int SIZE = 8;
        public static final int FULL = 0xFF;

        public void drawLine(byte[] screen, int width, int xl, int x2, int y) {
            int offset = y * width / SIZE;

            int sByte = xl / SIZE + offset;
            int eByte = x2 / SIZE + offset;

            for (int i = sByte; i <= eByte; i++) {
                screen[i] = (byte) FULL;
            }

            screen[sByte] &= trailingOnes(SIZE - xl % SIZE);
            screen[eByte] &= headingOnes(x2 % SIZE + 1);
        }

        private byte headingOnes(int count) {
            return (byte) ~(FULL << count);
        }

        private byte trailingOnes(int count) {
            return (byte) ~(FULL >> count);
        }
    }
}
