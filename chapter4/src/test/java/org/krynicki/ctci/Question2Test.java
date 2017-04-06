package org.krynicki.ctci;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by K on 2016-10-24.
 */
public class Question2Test {
    private Question2.ArrayToTree<Integer> converter = new Question2.ArrayToTree<>();

    @Test(expectedExceptions = NullPointerException.class)
    public void shouldThrowOnNull() throws Exception {
        converter.toTree(null);
    }

    @Test
    public void shouldWorkForOne() throws Exception {
        TreeNode<Integer> integerTreeNode = converter.toTree(new Integer[]{3});

        Assert.assertEquals(integerTreeNode.data, (Integer)3);
        Assert.assertNull(integerTreeNode.left());
        Assert.assertNull(integerTreeNode.right());
    }

    @Test
    public void shouldWorkForThree() throws Exception {
        TreeNode<Integer> integerTreeNode = converter.toTree(new Integer[]{1, 2, 3});

        Assert.assertEquals(integerTreeNode.data, (Integer)2);
        Assert.assertEquals(integerTreeNode.left().data, (Integer)1);
        Assert.assertEquals(integerTreeNode.right().data, (Integer)3);
    }

    @Test
    public void shouldWorkForFour() throws Exception {
        TreeNode<Integer> integerTreeNode = converter.toTree(new Integer[]{1, 2, 3, 4});

        Assert.assertEquals(integerTreeNode.data, (Integer)2);
        Assert.assertEquals(integerTreeNode.left().data, (Integer)1);
        Assert.assertEquals(integerTreeNode.right().data, (Integer)3);
        Assert.assertEquals(integerTreeNode.right().right().data, (Integer)4);
    }
}