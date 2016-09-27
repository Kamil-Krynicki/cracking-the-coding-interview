package org.krynicki.ctci;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by K on 2016-09-27.
 */
public class Question8Test extends AbstractChapter2Test {

    Question8 q = new Question8();

    @Test
    public void testLoopStart() throws Exception {
        Assert.assertNull(q.loopStart(null));
        Assert.assertNull(q.loopStart(getNodeList(1, 2, 3, 4)));

        Node list1 = getNodeList(0, 1, 2, 3, 4, 5);

        Node lastNode = list1;
        Node middleNode;

        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }

        //only loop
        lastNode.next = list1;
        Assert.assertEquals(q.loopStart(list1), lastNode.next);

        middleNode = list1;
        for (int i = 0; i < 3; i++) {
            middleNode = middleNode.next;
        }

        //some tail, some loop
        lastNode.next = middleNode;
        Assert.assertEquals(q.loopStart(list1), lastNode.next);

        //degenerate loop
        lastNode.next = lastNode;
        Assert.assertEquals(q.loopStart(list1), lastNode.next);


    }

}