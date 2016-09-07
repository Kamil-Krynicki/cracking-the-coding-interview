package org.krynicki.ctci;

/**
 * Created by K on 2016-09-07.
 */
public class Question2 {
    Node kthLast(Node root, int k) {
        if (root == null) return null;

        Node runner1 = root;

        while (k-- > 0) {
            if (runner1 == null) {
                return null;
            }
            runner1 = runner1.next;
        }

        Node runner2 = root;

        while (runner1.next != null) {
            runner1 = runner1.next;
            runner2 = runner2.next;
        }

        return runner2;
    }
}
