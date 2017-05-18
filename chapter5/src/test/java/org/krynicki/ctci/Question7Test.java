package org.krynicki.ctci;

import junit.framework.Assert;
import org.testng.annotations.Test;

public class Question7Test {
    @Test
    public void shouldWorkFine() {
        Assert.assertEquals(new Question7().pairwiseSwap(0), 0);
        Assert.assertEquals(new Question7().pairwiseSwap(~0), ~0);
    }
}