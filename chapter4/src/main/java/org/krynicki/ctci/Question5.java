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

        int currentData = root.data;
        if(currentData < min || currentData > max)
            return false;

        TreeNode<Integer> l = root.left();
        if (l != null && currentData < l.data)
            return false;

        TreeNode<Integer> r = root.right();
        if (r != null && currentData > r.data)
            return false;

        return isValidBst(l, min, currentData) && isValidBst(r, currentData, max);
    }
}
