package org.krynicki.ctci;

import junit.framework.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by K on 2016-09-08.
 */
public class Question4Test extends AbstractChapter2TestHelper {
    private Question4 q = new Question4();

    @Test
    public void testBase() throws Exception {
        Assert.assertNull(q.partition(null, ThreadLocalRandom.current().nextInt()));

        Assert.assertTrue(q.partition(getNodeList(1, 2, 3), 4).deepEquals(getNodeList(3, 2, 1)));

        Assert.assertTrue(q.partition(getNodeList(5, 1, 2, 3), 4).deepEquals(getNodeList(3, 2, 1, 5)));
        Assert.assertTrue(q.partition(getNodeList(1, 2, 3, 5), 4).deepEquals(getNodeList(3, 2, 1, 5)));

        Assert.assertTrue(q.partition(getNodeList(6, 7, 8), 4).deepEquals(getNodeList(8, 7, 6)));

        Assert.assertTrue(q.partition(getNodeList(3, 6, 7, 8), 4).deepEquals(getNodeList(3, 8, 7, 6)));
        Assert.assertTrue(q.partition(getNodeList(6, 7, 8, 3), 4).deepEquals(getNodeList(3, 8, 7, 6)));


        Assert.assertTrue(q.partition(getNodeList(3, 9, 3), 4).deepEquals(getNodeList(3, 3, 9)));
        Assert.assertTrue(q.partition(getNodeList(9, 3, 9), 4).deepEquals(getNodeList(3, 9, 9)));

        Assert.assertTrue(q.partition(getNodeList(3, 9, 4, 3), 4).deepEquals(getNodeList(3, 3, 4, 9)));
        Assert.assertTrue(q.partition(getNodeList(9, 3, 4, 9), 4).deepEquals(getNodeList(3, 9, 4, 9)));


        Assert.assertTrue(q.partition(getNodeList(8), 7).deepEquals(getNodeList(8)));
        Assert.assertTrue(q.partition(getNodeList(8), 8).deepEquals(getNodeList(8)));
        Assert.assertTrue(q.partition(getNodeList(8), 9).deepEquals(getNodeList(8)));

    }
}