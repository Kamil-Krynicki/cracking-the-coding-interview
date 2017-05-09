package org.krynicki.ctci;

/**
 * Created by kamil.krynicki on 09/05/2017.
 */
public class Question3 {
    static class BitFlipper {
        private int in;

        public BitFlipper(int in) {
            this.in = in;
        }

        int flipToWin() {
            int prvOnes = 0, nextOnes = 0;

            int max = 0;
            do {
                nextOnes = consumeOnes();
                max = Math.max(nextOnes + 1 + prvOnes, max);
                prvOnes = nextOnes;
                consume();
            } while (!done());

            return max;
        }

        private int consumeOnes() {
            int count = 0;

            while (!done() && endsInOne()) {
                consume();
                count++;
            }

            return count;
        }

        private boolean done() {
            return in == 0;
        }

        private void consume() {
            in >>>= 1;
        }

        private boolean endsInOne() {
            return (in & 1) != 0;
        }
    }
}
