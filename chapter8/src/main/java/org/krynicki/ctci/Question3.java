package org.krynicki.ctci;

/**
 * Created by kamil.krynicki on 29/05/2017.
 */

public class Question3 {

    public int magicIndexAllDistinct(int[] in) {
        return magicIndexAllDistinct(in, 0, in.length - 1);
    }

    private int magicIndexAllDistinct(int[] in, int from, int to) {
        if (to < from)
            return -1;

        int middle = (from + to) / 2;

        if (in[middle] > middle)
            return magicIndexAllDistinct(in, from, middle - 1);

        if (in[middle] < middle)
            return magicIndexAllDistinct(in, middle + 1, to);

        return middle;
    }

    public int magicIndexRepetitions(int[] in) {
        return magicIndexRepetitions(in, 0, in.length - 1);
    }

    private int magicIndexRepetitions(int[] in, int from, int to) {
        if (to < from)
            return -1;

        int middle = (from + to) / 2;

        if(in[middle] == middle)
            return middle;

        int result = magicIndexRepetitions(in, from, middle - 1);

        if (result > -1)
            return result;
        else
            return magicIndexRepetitions(in, middle + 1, to);
    }

}
