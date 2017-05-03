package org.krynicki.ctci;

import junit.framework.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.krynicki.ctci.Question11.Randomizer;
import static org.krynicki.ctci.TreeNode.node;

public class Question11Test {

    public static final double COUNT = 1E6;
    public static final int APPROX_FACTOR = 100;
    private Randomizer rand;

    @BeforeTest
    public void init() {
        rand = new Randomizer();
    }

    @Test
    public void shouldFindSuccessorOfLast() {
        TreeNode<Integer> root =
                node(1).withLeft(node(0)).withRight(node(2).withRight(node(4).withLeft(node(3))));

        int[] results = new int[5];

        for (int i = 0; i < COUNT; i++) {
            results[rand.randomNode(root).data]++;
        }

        for (int i = 0; i < results.length; i++) {
            for (int j = i + 1; j < results.length; j++) {
                Assert.assertEquals(approx(results[j], COUNT), approx(results[i], COUNT));
            }
        }
    }

    private long approx(int result, double count) {
        return Math.round((double) APPROX_FACTOR * result / count);
    }
}