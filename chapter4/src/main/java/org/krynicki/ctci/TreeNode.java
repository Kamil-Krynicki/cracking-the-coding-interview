package org.krynicki.ctci;

import sun.reflect.generics.tree.Tree;

/**
 * Created by K on 2016-10-20.
 */
public class TreeNode<T> {

    public static <T> TreeNode<T> node(T value) {
        return new TreeNode<>(value, null);
    }

    public T data;

    private TreeNode<T> parent;

    private TreeNode<T> l;
    private TreeNode<T> r;

    private TreeNode(T data, TreeNode<T> parent) {
        this.parent = parent;
        this.data = data;
    }

    public TreeNode<T> left() {
        return l;
    }

    public TreeNode<T> right() {
        return r;
    }

    public TreeNode<T> parent() {return parent;}

    public TreeNode<T> withLeft(TreeNode<T> left) {
        this.l = left;
        if(left!=null)
            left.parent = this;
        return this;
    }

    public TreeNode<T> withRight(TreeNode<T> right) {
        this.r = right;
        if(right!=null)
            right.parent = this;
        return this;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                '}';
    }
}
