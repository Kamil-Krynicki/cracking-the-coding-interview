package org.krynicki.ctci;

/**
 * Created by K on 2016-10-20.
 */
public class TreeNode<T extends Comparable<T>> {

    public static <T extends Comparable<T>> TreeNode<T> node(T value) {
        return new TreeNode<>(value);
    }

    public T data;

    private TreeNode<T> l;
    private TreeNode<T> r;

    public TreeNode(T data) {
        this.data = data;
    }

    public TreeNode<T> left() {
        return l;
    }

    public TreeNode<T> right() {
        return r;
    }

    public TreeNode<T> withLeft(TreeNode<T> left) {
        this.l = left;
        return this;
    }

    public TreeNode<T> withRight(TreeNode<T> right) {
        this.r = right;
        return this;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                '}';
    }
}
