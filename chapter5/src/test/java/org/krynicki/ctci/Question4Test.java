package org.krynicki.ctci;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Question4Test {

    @Test
    public void test() {

        Assert.assertEquals(new Question4().nextSmallestSameOnes(0b11011101111), 8);
        Assert.assertEquals(new Question4().nextSmallestSameOnes(0b1100111001111), 5);
        Assert.assertEquals(new Question4().nextSmallestSameOnes(0b110001110001111), 5);
    }
}