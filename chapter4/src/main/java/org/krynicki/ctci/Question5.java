package org.krynicki.ctci;

/**
 * Created by K on 10.04.2017.
 */
public class Question5 {
    public boolean isValidBst(TreeNode<Integer> root) {
        return isValidBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBst(TreeNode<Integer> root, int min, int max) {
        if(root == null)
            return true;

        if(root.data < min || root.data > max)
            return false;

        return isValidBst(root.left(), min, root.data) && isValidBst(root.right(), root.data, max);
    }
}
