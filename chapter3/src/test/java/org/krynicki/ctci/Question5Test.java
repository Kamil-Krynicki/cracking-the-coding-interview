package org.krynicki.ctci;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

import static org.testng.Assert.*;

/**
 * Created by K on 2016-10-13.
 */
public class Question5Test {
    Question5.SortStack<Integer> sortStack;

    @BeforeTest
    void init(){
        sortStack = new Question5.SortStack<>();
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void shouldFailOnNull() throws Exception {
        sortStack.sort(null);
    }

    @Test
    public void shouldWorkOnEmpty() throws Exception {
        sortStack.sort(new LinkedListStack<Integer>());
    }

    @Test
    public void shouldSortAlreadySorted() throws Exception {
        LinkedListStack<Integer> stack = new LinkedListStack<Integer>(4, 3, 2, 1);
        sortStack.sort(stack);

        Assert.assertEquals(stack, new LinkedListStack<Integer>(4, 3, 2, 1));
    }

    @Test
    public void shouldWorkForPermutations() throws Exception {
        LinkedListStack<Integer> stack = new LinkedListStack<Integer>(4, 3, 2, 1, 5, 4, 3, 2);
        LinkedListStack<Integer> sortedStack = new LinkedListStack<>(5, 4, 4, 3, 3, 2, 2, 1);

        for(int i=0;i<100;i++) {
            stack.shuffle();
            sortStack.sort(stack);

            Assert.assertEquals(stack, sortedStack);
        }
    }

    @Test
    public void shouldFail() throws Exception {
        LinkedListStack<Integer> stack = new LinkedListStack<Integer>(4, 3, 2, 1, 5);
        LinkedListStack<Integer> sortedStack = new LinkedListStack<>(4, 4, 2, 2, 1);

        for(int i=0;i<10000;i++) {
            sortStack.sort(stack);
            stack.shuffle();

            Assert.assertNotEquals(stack, sortedStack);
        }
    }
}