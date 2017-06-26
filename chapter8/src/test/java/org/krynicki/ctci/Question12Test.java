package org.krynicki.ctci;

import junit.framework.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class Question12Test {

    private Question12 alg = new Question12();

    @Test
    public void placeQueens() throws Exception {

        List<int[]> ints = alg.placeQueens(8);

        for (int[] layout : ints)
            Assert.assertTrue(alg.isValid(layout));
    }

    @Test
    public void testCanPlaceEmpty() throws Exception {
        int[] distribution = emptyDistribution();

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                Assert.assertTrue(alg.isAvailable(x, y, distribution));
            }
        }
    }

    @Test
    public void testCanPlace00Full() throws Exception {
        int[] distribution = emptyDistribution();
        distribution[0] = 0;

        for (int x = 0; x < 8; x++)
            Assert.assertFalse(alg.isAvailable(x, x, distribution));
    }

    @Test
    public void testCanPlace08Full() throws Exception {
        int[] distribution = emptyDistribution();
        distribution[7] = 0;

        for (int x = 0; x < 8; x++)
            Assert.assertFalse(alg.isAvailable(x, 7 - x, distribution));
    }

    @Test
    public void testCanPlace14Full() throws Exception {
        int[] distribution = emptyDistribution();
        distribution[4] = 1;

        Assert.assertFalse(alg.isAvailable(4, 1, distribution));
        Assert.assertFalse(alg.isAvailable(5, 2, distribution));
        Assert.assertTrue(alg.isAvailable(5, 3, distribution));
        Assert.assertFalse(alg.isAvailable(3, 2, distribution));
        Assert.assertTrue(alg.isAvailable(3, 3, distribution));
    }

    private int[] emptyDistribution() {
        int[] distribution = new int[8];
        Arrays.fill(distribution, Integer.MIN_VALUE);
        return distribution;
    }
}