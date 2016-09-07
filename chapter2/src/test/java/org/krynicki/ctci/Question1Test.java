package org.krynicki.ctci;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by K on 2016-09-05.
 */
public class Question1Test extends AbstractChapter2TestHelper {
    Question1 q = new Question1();

    @Test
    public void testBaseCase() throws Exception {
        q.removeDups(null);
    }

    @Test
    public void testVariants() throws Exception {
        Assert.assertTrue(q.removeDups(getNodeList(2)).deepEquals(getNodeList(2)));
        Assert.assertTrue(q.removeDups(getNodeList(2, 3)).deepEquals(getNodeList(2, 3)));
        Assert.assertTrue(q.removeDups(getNodeList(2, 2, 2)).deepEquals(getNodeList(2)));
        Assert.assertTrue(q.removeDups(getNodeList(2, 3, 2)).deepEquals(getNodeList(2, 3)));
        Assert.assertTrue(q.removeDups(getNodeList(3, 2, 2)).deepEquals(getNodeList(3, 2)));
    }

    @Test
    public void testVariantsNoData() throws Exception {
        Assert.assertTrue(q.removeDupsNoData(getNodeList(2)).deepEquals(getNodeList(2)));
        Assert.assertTrue(q.removeDupsNoData(getNodeList(2, 3)).deepEquals(getNodeList(2, 3)));
        Assert.assertTrue(q.removeDupsNoData(getNodeList(2, 2, 2)).deepEquals(getNodeList(2)));
        Assert.assertTrue(q.removeDupsNoData(getNodeList(2, 3, 2)).deepEquals(getNodeList(2, 3)));
        Assert.assertTrue(q.removeDupsNoData(getNodeList(3, 2, 2)).deepEquals(getNodeList(3, 2)));
    }
}