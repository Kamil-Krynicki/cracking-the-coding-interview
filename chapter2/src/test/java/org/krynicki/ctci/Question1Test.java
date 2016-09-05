package org.krynicki.ctci;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by K on 2016-09-05.
 */
public class Question1Test extends AbstractTestHelper{
    Question1 q = new Question1();

    @Test
    public void testBaseCase() throws Exception {
        q.removeDups(null);
    }

    @Test
    public void testVariants() throws Exception {
        Assert.assertTrue(q.removeDups(getNodeList(new int[]{2})).deepEquals(getNodeList(new int[]{2})));
        Assert.assertTrue(q.removeDups(getNodeList(new int[]{2, 3})).deepEquals(getNodeList(new int[]{2, 3})));
        Assert.assertTrue(q.removeDups(getNodeList(new int[]{2, 2, 2})).deepEquals(getNodeList(new int[]{2})));
        Assert.assertTrue(q.removeDups(getNodeList(new int[]{2, 3, 2})).deepEquals(getNodeList(new int[]{2, 3})));
    }
}