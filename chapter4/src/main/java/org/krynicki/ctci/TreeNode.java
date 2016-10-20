package org.krynicki.ctci;

/**
 * Created by K on 2016-10-20.
 */
public class TreeNode<T> {
    public T data;

    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode(T data) {
        this.data = data;
    }
}
