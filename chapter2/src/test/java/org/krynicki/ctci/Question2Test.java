package org.krynicki.ctci;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by K on 2016-09-07.
 */
public class Question2Test extends AbstractChapter2Test {
    Question2 q = new Question2();

    @Test
    public void testVariants() throws Exception {
        Assert.assertNull(q.kthLast(null, 10));
        Assert.assertNull(q.kthLast(getNodeList(2), 10));

        Assert.assertEquals(q.kthLast(getNodeList(5), 0), getNodeList(5));
        Assert.assertEquals(q.kthLast(getNodeList(2, 3), 0), getNodeList(3));
        Assert.assertEquals(q.kthLast(getNodeList(2, 3), 1), getNodeList(2));


        Assert.assertEquals(q.kthLast(getNodeList(2, 3), 1), getNodeList(2));
        Assert.assertEquals(q.kthLast(getNodeList(2, 3, 4), 2), getNodeList(2));
        Assert.assertEquals(q.kthLast(getNodeList(2, 3, 4, 5), 3), getNodeList(2));

        Assert.assertEquals(q.kthLast(getNodeList(1, 2, 3, 4), 2), getNodeList(2));
        Assert.assertEquals(q.kthLast(getNodeList(1, 2, 3, 4, 5), 3), getNodeList(2));

        Assert.assertEquals(q.kthLast(getNodeList(0, 1, 2, 3, 4), 2), getNodeList(2));
        Assert.assertEquals(q.kthLast(getNodeList(0, 1, 2, 3, 4, 5), 3), getNodeList(2));

    }
}