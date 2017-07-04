package org.krynicki.ctci;

import org.junit.Assert;
import org.testng.annotations.Test;

public class Question1Test {

    @Test
    public void shouldWorkForEmpty() {
        int[] array1 = {};
        int[] array2 = {};

        int[] expected = {};

        check(array1, array2, expected);
    }

    @Test
    public void finish1early() {
        int[] array1 = {4, 5, 6, 0, 0, 0};
        int[] array2 = {1, 2, 3};

        int[] expected = {1, 2, 3, 4, 5, 6};

        check(array1, array2, expected);
    }

    @Test
    public void finish2early() {
        int[] array1 = {1, 2, 3, 0, 0, 0};
        int[] array2 = {4, 5, 6};

        int[] expected = {1, 2, 3, 4, 5, 6};

        check(array1, array2, expected);
    }


    @Test
    public void interleave() {
        int[] array1 = {1, 3, 5, 0, 0, 0};
        int[] array2 = {2, 4, 6};

        int[] expected = {1, 2, 3, 4, 5, 6};

        check(array1, array2, expected);
    }


    private void check(int[] array1, int[] array2, int[] expected) {
        Assert.assertArrayEquals(expected, new Question1().merge(array1, array2));
    }
}