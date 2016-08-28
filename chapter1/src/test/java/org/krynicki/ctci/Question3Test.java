package org.krynicki.ctci;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by K on 2016-08-28.
 */
public class Question3Test {
    private static char[] in = "Mr John Smith    ".toCharArray();
    private static int inSize = 13;
    private  static char [] out = "Mr%20John%20Smith".toCharArray();

    private static Question3 q = new Question3();

    @Test
    public void testUrlfy() throws Exception {
        Assert.assertEquals(q.urlfy(in, 13), out);
    }
}