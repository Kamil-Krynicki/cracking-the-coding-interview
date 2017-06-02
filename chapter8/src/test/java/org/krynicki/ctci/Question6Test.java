package org.krynicki.ctci;

import junit.framework.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class Question6Test {
    private static final Random RANDOM = new Random();
    private static final Question6 alg = new Question6();

    @Test
    public void test() {
        Question6.HanoiStack[] solution = alg.printSolutionForHanoi(20);

        Assert.assertTrue(solution[0].isEmpty());
        Assert.assertTrue(solution[1].isEmpty());

        Assert.assertFalse(solution[2].isEmpty());
    }
}