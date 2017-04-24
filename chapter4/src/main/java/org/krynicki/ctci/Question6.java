package org.krynicki.ctci;

/**
 * Created by K on 24.04.2017.
 */
public class Question6 {
    public TreeNode<Integer> successor(TreeNode<Integer> node) {
        if (!exists(node))
            return null;

        if (exists(node.right())) {
            return min(node.right());
        }

        return leftReachedParent(node);
    }

    private TreeNode<Integer> leftReachedParent(TreeNode<Integer> node) {
        TreeNode<Integer> tmp = node;

        while(exists(tmp.parent()) && tmp.parent().right() == tmp) {
            tmp = tmp.parent();
        }

        return tmp.parent();
    }

    private TreeNode<Integer> min(TreeNode<Integer> node) {
        if (!exists(node))
            return null;

        if (exists(node.left())) {
            return min(node.left());
        } else {
            return node;
        }
    }

    private boolean exists(TreeNode<Integer> node) {
        return node != null;
    }
}
