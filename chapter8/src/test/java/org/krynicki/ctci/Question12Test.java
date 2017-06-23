package org.krynicki.ctci;

import junit.framework.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class Question12Test {


    @Test
    public void placeQueens() throws Exception {
        Question12 question12 = new Question12();

        long t1 = System.currentTimeMillis();
        List<int[]> ints = null;
        for(int i=0;i<10000;i++)
            ints = question12.placeQueens(8);
        long t2 = System.currentTimeMillis();

        System.out.println(t2 - t1);

        int i = 0;
        for(int[] layout : ints) {
            Assert.assertTrue(question12.isValid(layout));
            //System.out.println(i++ +" "+question12.visualize(layout));
        }
    }

    @Test
    public void testCanPlaceEmpty() throws Exception {
        Question12 question12 = new Question12();

        int[] distribution = emptyDistribution();

        for (int x = 0; x <= 8; x++) {
            for (int y = 0; y <= 8; y++) {
                System.out.println(x + " " + y);
                Assert.assertTrue(question12.isAvailable(x, y, distribution));
            }
        }
    }

    @Test
    public void testCanPlace00Full() throws Exception {
        Question12 question12 = new Question12();

        int[] distribution = emptyDistribution();
        distribution[0]=0;

        for (int x = 0; x <= 8; x++) {
                System.out.println(x + " " + x);
                Assert.assertFalse(question12.isAvailable(x, x, distribution));
            }
    }

    @Test
    public void testCanPlace08Full() throws Exception {
        Question12 question12 = new Question12();

        int[] distribution = emptyDistribution();
        distribution[7]=0;

        for (int x = 0; x <= 8; x++) {
            System.out.println(x + " " + (7-x));
            Assert.assertFalse(question12.isAvailable(x, 7 - x, distribution));
        }
    }

    @Test
    public void testCanPlace14Full() throws Exception {
        Question12 question12 = new Question12();

        int[] distribution = emptyDistribution();
        distribution[4]=1;

        Assert.assertFalse(question12.isAvailable(4, 1, distribution));
        Assert.assertFalse(question12.isAvailable(5, 2, distribution));
        Assert.assertTrue(question12.isAvailable(5, 3, distribution));
        Assert.assertFalse(question12.isAvailable(3, 2, distribution));
        Assert.assertTrue(question12.isAvailable(3, 3, distribution));
    }

    private int[] emptyDistribution() {
        int[] distribution = new int[8];
        Arrays.fill(distribution, Integer.MIN_VALUE);
        return distribution;
    }
}