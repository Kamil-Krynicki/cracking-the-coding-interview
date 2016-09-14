package org.krynicki.ctci;

import java.util.Deque;
import java.util.LinkedList;

public class Question6 {

    // very quick - only two runs over the list
    // I believe this is the minimum for a single linked list
    boolean isPalindrome(Node root) {
        if (root == null) return false;

        int size = 0;

        Node runner;

        runner = root;
        while (runner != null) {
            runner = runner.next;
            size++;
        }

        Deque<Node> stack = new LinkedList<>();
        int i = 0;

        runner = root;
        while (i < size / 2) {
            stack.push(runner);
            runner = runner.next;
            i++;
        }

        if (size % 2 == 1) {
            runner = runner.next;
            i++;
        }

        while (i < size) {
            if (stack.pop().id != runner.id) {
                return false;
            }
            runner = runner.next;
            i++;
        }

        return true;
    }
}
