package org.krynicki.ctci;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.krynicki.ctci.TreeNode.node;
import static org.testng.Assert.*;

/**
 * Created by K on 24.04.2017.
 */
public class Question6Test {
    Question6 alg = new Question6();


    @Test
    public void shouldFindSuccessorOfLast() {
        TreeNode<Integer> test;
        TreeNode<Integer> root = node(5)
                .withLeft(node(3))
                .withRight(test = node(9).withLeft(node(7)));

        Assert.assertEquals(alg.successor(test), null);
    }

    @Test
    public void shouldFindSuccessorOfFirst() {
        TreeNode<Integer> test;
        TreeNode<Integer> root = node(5)
                .withLeft(test = node(3))
                .withRight(node(9).withLeft(node(7)));

        Assert.assertEquals(alg.successor(test).data, (Integer)5);
    }

    @Test
    public void shouldFindSuccessorOfTop() {
        TreeNode<Integer> test;
        TreeNode<Integer> root = test = node(5)
                .withLeft(test = node(3))
                .withRight(node(9).withLeft(node(7)));

        Assert.assertEquals(alg.successor(test).data, (Integer)7);
    }
}