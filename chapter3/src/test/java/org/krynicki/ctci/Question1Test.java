package org.krynicki.ctci;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by K on 2016-09-29.
 */
public class Question1Test extends AbstractChapter3Test {

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void shouldFailOnNegativeStackNumber() throws Exception {
        Question1.ThreeStacks stacks = new Question1.ThreeStacks();
        stacks.popStack(-1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void shouldFailOnLargeStackNumber() throws Exception {
        Question1.ThreeStacks stacks = new Question1.ThreeStacks();
        stacks.popStack(3);
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void shouldFailOnEmptyStack() throws Exception {
        Question1.ThreeStacks stacks = new Question1.ThreeStacks();
        stacks.popStack(2);
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void shouldOverflow() throws Exception {
        Question1.ThreeStacks stacks = new Question1.ThreeStacks();
        while (true) {
            stacks.pushStack("", ThreadLocalRandom.current().nextInt(3));
        }
    }

    @Test()
    public void shouldFillAndEmptyOneStack() throws Exception {
        Question1.ThreeStacks stacks = new Question1.ThreeStacks();

        stacks.pushStack("A", 0);
        stacks.pushStack("B", 0);
        stacks.pushStack("C", 0);
        stacks.pushStack("D", 0);
        stacks.pushStack("E", 0);
        stacks.pushStack("F", 0);

        Assert.assertEquals(stacks.popStack(0), "F");
        Assert.assertEquals(stacks.popStack(0), "E");
        Assert.assertEquals(stacks.popStack(0), "D");
        Assert.assertEquals(stacks.popStack(0), "C");
        Assert.assertEquals(stacks.popStack(0), "B");
        Assert.assertEquals(stacks.popStack(0), "A");
    }

    @Test()
    public void shouldWorkFine() throws Exception {
        Question1.ThreeStacks stacks = new Question1.ThreeStacks();

        stacks.pushStack("A1", 1);
        stacks.pushStack("B1", 1);
        stacks.pushStack("C1", 1);
        stacks.pushStack("A2", 2);
        stacks.pushStack("D1", 1);
        stacks.pushStack("B2", 2);

        Assert.assertEquals(stacks.nextFree, 6);
        Assert.assertEquals(stacks.internalData[stacks.nextFree - 1].data, "B2");
        Assert.assertEquals(stacks.popStack(1), "D1");
        Assert.assertEquals(stacks.nextFree, 5);
        Assert.assertEquals(stacks.internalData[stacks.nextFree - 1].data, "B2");
        Assert.assertEquals(stacks.popStack(2), "B2");
        Assert.assertEquals(stacks.nextFree, 4);
        Assert.assertEquals(stacks.internalData[stacks.nextFree - 1].data, "A2");
        stacks.pushStack("A0", 0);
        stacks.pushStack("B0", 0);
        stacks.pushStack("C0", 0);
        Assert.assertEquals(stacks.nextFree, 7);
        Assert.assertEquals(stacks.internalData[stacks.nextFree - 1].data, "C0");
        Assert.assertEquals(stacks.popStack(0), "C0");
        Assert.assertEquals(stacks.popStack(0), "B0");
        Assert.assertEquals(stacks.popStack(0), "A0");
        Assert.assertEquals(stacks.internalData[stacks.nextFree - 1].data, "A2");
    }
}