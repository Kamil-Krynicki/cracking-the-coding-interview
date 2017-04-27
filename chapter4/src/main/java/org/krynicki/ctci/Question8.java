package org.krynicki.ctci;

import com.google.common.collect.Lists;

import java.util.Deque;

/**
 * Created by kamil.krynicki on 27/04/2017.
 */
public class Question8 {
    void findPaths(TreeNode<Integer> root, int value) {
        innerFind(Lists.<TreeNode<Integer>>newLinkedList(), value, root);
    }

    void innerFind(Deque<TreeNode<Integer>> currentPath, int valueLeft,
                   TreeNode<Integer> current) {
        if (current == null)
            return;

        currentPath.addLast(current);
        int newValue = valueLeft - current.data;

        if (newValue < 0) {
            newValue += currentPath.getFirst().data;
            currentPath.removeFirst();
        } else if (newValue == 0) {
            System.out.println(currentPath);
        }

        innerFind(Lists.newLinkedList(currentPath), newValue, current.left());
        innerFind(Lists.newLinkedList(currentPath), newValue, current.right());
    }
}
