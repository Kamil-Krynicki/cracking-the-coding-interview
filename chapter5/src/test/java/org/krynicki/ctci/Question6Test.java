package org.krynicki.ctci;

import junit.framework.Assert;
import org.testng.annotations.Test;

public class Question6Test {
    @Test
    private void shouldWorkFine() {
        Assert.assertEquals(new Question6().flipDistance(29, 15), 2);
    }
}