package org.krynicki.ctci;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

import static org.testng.Assert.*;

/**
 * Created by K on 2016-10-17.
 */
public class Question4Test {
    Question4.MyQueue<Integer> queue;

    @BeforeTest
    void init(){
        queue = new  Question4.MyQueue<>();
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void shouldBeNullOnEmptyDequeue() throws Exception {
        queue.dequeue();
    }

    @Test
    public void shouldWorkOnEmpty() throws Exception {
        queue.enqueque(1);
        queue.enqueque(2);
        queue.enqueque(3);
        queue.enqueque(4);
        queue.enqueque(5);
        queue.enqueque(6);

        Assert.assertEquals((int)queue.dequeue(), 1);
        Assert.assertEquals((int)queue.dequeue(), 2);
        Assert.assertEquals((int)queue.dequeue(), 3);
        Assert.assertEquals((int)queue.dequeue(), 4);
        Assert.assertEquals((int)queue.dequeue(), 5);
        Assert.assertEquals((int)queue.dequeue(), 6);
    }
}