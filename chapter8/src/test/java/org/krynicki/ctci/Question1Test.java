package org.krynicki.ctci;

import junit.framework.Assert;
import org.testng.annotations.Test;

public class Question1Test {

    @Test
    public void initTesting() {
        Assert.assertEquals(new Question1().stepCombinations(0), 1);
        Assert.assertEquals(new Question1().stepCombinations(1), 1);
        Assert.assertEquals(new Question1().stepCombinations(2), 2);
        Assert.assertEquals(new Question1().stepCombinations(3), 4);
        Assert.assertEquals(new Question1().stepCombinations(30), 53798080);
        Assert.assertEquals(new Question1().stepCombinations(60), 4680045560037375l);
    }
}