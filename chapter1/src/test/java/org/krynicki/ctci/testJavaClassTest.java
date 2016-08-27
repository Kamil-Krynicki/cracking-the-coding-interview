package org.krynicki.ctci;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by K on 2016-08-26.
 */
public class testJavaClassTest {

    @Test(invocationCount = 100)
    public void method1Test(){
        Assert.assertEquals(1, 1);
    }
}