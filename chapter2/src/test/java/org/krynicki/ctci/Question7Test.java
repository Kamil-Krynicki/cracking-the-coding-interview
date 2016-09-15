package org.krynicki.ctci;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by K on 2016-09-15.
 */
public class Question7Test extends AbstractChapter2Test {

    Question7 q = new Question7();

    @Test
    public void testBase() throws Exception {
        Assert.assertNull(q.intersection(null, null));
        Assert.assertNull(q.intersection(null, getNodeList(0)));
        Assert.assertNull(q.intersection(getNodeList(0), null));

        Node list1 = getNodeList(0, 1, 2, 3, 4, 5);
        Node list2 = getNodeList(6, 7, 8, 9, 10, 11);

        System.out.print(list1.deepToString());
        System.out.print(list2.deepToString());

        Assert.assertNull(q.intersection(list1, list2));

        Node middleNode = list2;
        Node lastNode = list1;

        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }

        for (int i = 0; i < 3; i++) {
            middleNode = middleNode.next;
        }

        lastNode.next = middleNode;

        System.out.print(list1.deepToString());
        System.out.print(list2.deepToString());

        Assert.assertEquals(q.intersection(list1, list2), middleNode);

    }

}