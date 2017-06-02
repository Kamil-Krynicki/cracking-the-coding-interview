package org.krynicki.ctci;

import junit.framework.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class Question5Test {

    private static final Random RANDOM = new Random();
    private static final Question5 alg = new Question5();

    @Test
    public void test() {
        for(int i = 0; i < 1000; i++) {
            int a = RANDOM.nextInt(2000);
            int b = RANDOM.nextInt(2000);

            Assert.assertEquals(a * b, alg.mul(a, b));
        }
    }
}