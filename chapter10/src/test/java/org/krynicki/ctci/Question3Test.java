package org.krynicki.ctci;

import com.google.common.primitives.Ints;
import junit.framework.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Random;

public class Question3Test {

    public static final int TEST_COUNT = 1000;
    public static final int TEST_SIZE = 1000;

    private Question3 alg = new Question3();


    @Test
    public void test() {
        int[] array = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};

        Assert.assertEquals(8, alg.find(array, 5));
    }

    @Test
    public void regressionTestMinIndex() {
        int j = 0;
        while (j++ < TEST_COUNT) {
            int[] array = randomSortedArray(TEST_SIZE);
            int min = min(array);

            for (int i = 0; i < array.length; i++, array = rot(array))
                Assert.assertEquals(min, array[alg.minIndex(array, 0, TEST_SIZE - 1)]);
        }
    }

    private int min(int[] array) {
        return Ints.min(array);
    }

    private int[] randomSortedArray(int size) {
        int[] result = new int[size];

        Random random = new Random(System.currentTimeMillis());

        for (int i = 0; i < size; i++)
            result[i] = random.nextInt(TEST_SIZE / 2);

        Arrays.sort(result);

        return result;
    }

    private int[] rot(int[] array) {
        int first = array[0];

        System.arraycopy(array, 1, array, 0, array.length - 1);

        array[array.length - 1] = first;

        return array;
    }
}