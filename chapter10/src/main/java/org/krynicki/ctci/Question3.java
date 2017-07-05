package org.krynicki.ctci;

import java.util.Arrays;

/**
 * Created by kamil.krynicki on 04/07/2017.
 */
public class Question3 {
    int find(int[] array, int key) {
        int minIndex = minIndex(array, 0, array.length - 1);

        int from = key > array[0] ? 0 : minIndex;
        int to = key > array[0] ? minIndex : array.length;

        return Arrays.binarySearch(array, from, to, key);
    }

    public int minIndex(int[] array, int from, int to) {
        if (from == to)
            return from;

        int mid = (to + from) / 2;

        if (array[mid] < array[from])
            return minIndex(array, from + 1, mid);

        if (array[mid] > array[to])
            return minIndex(array, mid + 1, to);

        return from;
    }
}
