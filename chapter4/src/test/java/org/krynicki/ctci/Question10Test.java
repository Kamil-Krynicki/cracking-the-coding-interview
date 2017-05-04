package org.krynicki.ctci;

import junit.framework.Assert;
import org.testng.annotations.Test;

import static org.krynicki.ctci.Question10.SubTreeChecker;
import static org.krynicki.ctci.TreeNode.node;

public class Question10Test {
    @Test
    public void minimumExample() {
        TreeNode<Integer> tree1 =
                node(2).withLeft(node(2)).withRight(node(2).withRight(node(4).withLeft(node(3))));

        TreeNode<Integer> tree2 = node(2).withRight(node(4).withLeft(node(3)));

        SubTreeChecker checker = new SubTreeChecker();

        Assert.assertTrue(checker.isSubTree(tree1, tree2));
    }
}