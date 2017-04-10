package org.krynicki.ctci;

/**
 * Created by K on 10.04.2017.
 */
public class Question4 {
    public <T> boolean checkBalanced(TreeNode<T> root) {
        return height(root)!=-1;
    }

    private <T> int height(TreeNode<T> root) {
        if(root==null) return 0;

        int l = height(root.left());
        if(l == -1) return -1;

        int r = height(root.right());
        if(r == -1) return -1;

        if (Math.abs(l - r) > 1) {
            return -1;
        } else {
            return Math.max(l, r) + 1;
        }
    }
}
