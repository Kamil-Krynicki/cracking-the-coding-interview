package org.krynicki.ctci;

import junit.framework.Assert;
import org.testng.annotations.Test;

import static org.krynicki.ctci.Question8.FirstCommonAncestor;
import static org.krynicki.ctci.TreeNode.node;
import static org.mockito.Mockito.mock;

public class Question8Test {
    @Test
    public void shouldHandleNull() throws Exception {
        Assert.assertEquals(new FirstCommonAncestor().fca(null, null), null);
        Assert.assertEquals(new FirstCommonAncestor().fca(mock(TreeNode.class), null), null);
        Assert.assertEquals(new FirstCommonAncestor().fca(null, mock(TreeNode.class)), null);
    }

    @Test
    public void shouldFindSimpleParent() throws Exception {
        TreeNode<Integer> nodeA, nodeB, common;

        TreeNode<Integer> root = common = node(5)
                .withLeft(nodeB = node(3))
                .withRight(nodeA = node(9).withLeft(node(7)));

        Assert.assertEquals(new FirstCommonAncestor().fca(nodeA, nodeB), common);
    }

    @Test
    public void shouldFindSameNode() throws Exception {
        TreeNode<Integer> nodeA, nodeB, common;

        TreeNode<Integer> root = node(5)
                .withLeft(node(3))
                .withRight(common = nodeA = nodeB = node(9).withLeft(node(7)));

        Assert.assertEquals(new FirstCommonAncestor().fca(nodeA, nodeB), common);
    }

    @Test
    public void shouldFindSimpleParentInOneOfNodes() throws Exception {
        TreeNode<Integer> nodeA, nodeB, common;

        TreeNode<Integer> root = node(5)
                .withLeft(node(3))
                .withRight(common = nodeA = node(9).withLeft(nodeB = node(7)));

        Assert.assertEquals(new FirstCommonAncestor().fca(nodeA, nodeB), common);
    }

    @Test
    public void shouldReturnNullOnDifferedTrees() throws Exception {
        TreeNode<Integer> nodeA, nodeB, common = null;

        TreeNode<Integer> rootA = node(5)
                .withLeft(node(3))
                .withRight(node(9).withLeft(nodeA = node(7)));

        TreeNode<Integer> rootB = node(5)
                .withLeft(node(3))
                .withRight(nodeB = node(9).withLeft(node(7)));

        Assert.assertEquals(new FirstCommonAncestor().fca(nodeA, nodeB), common);
    }

}