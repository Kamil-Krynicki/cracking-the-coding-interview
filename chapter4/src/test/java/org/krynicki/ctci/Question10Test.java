package org.krynicki.ctci;

import org.testng.annotations.Test;

import static org.krynicki.ctci.TreeNode.node;

public class Question10Test {
    @Test
    public void shouldFindSuccessorOfLast() {
        TreeNode<Integer> root =
                node(3).withLeft(node(8)).withRight(node(2));

        Question10 alg = new Question10();

        alg.findPaths(root, 5);
    }
}