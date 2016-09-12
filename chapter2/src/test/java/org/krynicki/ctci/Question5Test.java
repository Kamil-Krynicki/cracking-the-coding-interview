package org.krynicki.ctci;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by K on 2016-09-12.
 */
public class Question5Test extends AbstractChapter2Test {
    Question5 q = new Question5();


    @Test
    public void testBase() throws Exception {
        Assert.assertNull(q.sum(null, null));
        Assert.assertTrue(getNodeList(0).deepEquals(q.sum(getNodeList(0), null)));
        Assert.assertTrue(getNodeList(0).deepEquals(q.sum(null, getNodeList(0))));

        // simple
        Assert.assertTrue(getNodeList(0).deepEquals(q.sum(getNodeList(0), getNodeList(0))));

        // carryover
        Assert.assertTrue(getNodeList(8, 1).deepEquals(q.sum(getNodeList(9), getNodeList(9))));

        // uneven
        Assert.assertTrue(getNodeList(8, 2).deepEquals(q.sum(getNodeList(7, 2), getNodeList(1))));

        // uneven with carryover
        Assert.assertTrue(getNodeList(0, 3).deepEquals(q.sum(getNodeList(9, 2), getNodeList(1))));

        // uneven with length increase
        Assert.assertTrue(getNodeList(0, 0, 1).deepEquals(q.sum(getNodeList(9, 9), getNodeList(1))));

        // even with carryover and length increase
        Assert.assertTrue(getNodeList(0, 0, 1).deepEquals(q.sum(getNodeList(0, 5), getNodeList(0, 5))));
    }

}