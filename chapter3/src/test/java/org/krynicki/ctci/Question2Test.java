package org.krynicki.ctci;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by K on 2016-10-03.
 */
public class Question2Test extends AbstractChapter3Test {

    Question2.MinStack minStack;

    @BeforeTest
    void init(){
        minStack = new Question2.MinStack();
    }


    @Test
    public void shouldWorkFine() throws Exception {
        minStack.push(10);

        Assert.assertEquals(minStack.min(), 10);

        minStack.push(11);

        Assert.assertEquals(minStack.min(), 10);

        minStack.push(9);
        minStack.push(12);

        Assert.assertEquals(minStack.min(), 9);
        Assert.assertEquals(minStack.pop(), 12);
        Assert.assertEquals(minStack.min(), 9);
        Assert.assertEquals(minStack.pop(), 9);
        Assert.assertEquals(minStack.min(), 10);
    }


    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void shouldNotWorkPopEmpty() throws Exception {
        minStack.pop();
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void shouldNotWorkMinEmpty() throws Exception {
        minStack.min();
    }
}