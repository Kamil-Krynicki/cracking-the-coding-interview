package org.krynicki.ctci;

import org.testng.annotations.Test;

import static org.krynicki.ctci.TreeNode.node;

public class Question12Test {
    @Test
    public void shouldFindSuccessorOfLast() {
        TreeNode<Integer> root =
                node(3).withLeft(node(8)).withRight(node(2));

        Question12 alg = new Question12();

        alg.findPaths(root, 5);
    }
}