package org.krynicki.ctci;

/**
 * Created by kamil.krynicki on 04/07/2017.
 */
public class Question1 {
    int[] merge(int[] to, int[] from) {
        int writeIndex = to.length - 1;
        int i = to.length - from.length - 1;
        int j = from.length - 1;

        while (writeIndex >= 0) {
            if (arrayDone(i) || !arrayDone(j) && from[j] > to[i]) {
                to[writeIndex--] = from[j--];
            } else {
                to[writeIndex--] = to[i--];
            }
        }

        return to;
    }

    private boolean arrayDone(int i) {
        return i < 0;
    }
}
