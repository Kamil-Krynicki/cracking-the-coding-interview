package org.krynicki.ctci;

import junit.framework.Assert;
import org.testng.annotations.Test;

public class Question14Test {

    @Test
    public void test() {
        Question14 k = new Question14();

        Assert.assertEquals(2, k.countPar("1^0|0|1", false));
        Assert.assertEquals(10, k.countPar("0&0&0&1^1|0", true));
    }


}