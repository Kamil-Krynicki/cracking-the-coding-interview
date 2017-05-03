package org.krynicki.ctci;

import org.testng.annotations.Test;

import static org.krynicki.ctci.Question9.BstSequences;
import static org.krynicki.ctci.TreeNode.node;

public class Question9Test {
    @Test
    public void shouldFindSuccessorOfLast() {
        TreeNode<Integer> root =
                node(2).withLeft(node(1)).withRight(node(3).withRight(node(4)));

        BstSequences alg = new BstSequences();

        System.out.println(alg.bstSequences(root));
    }
}