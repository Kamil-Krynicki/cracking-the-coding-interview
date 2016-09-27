package org.krynicki.ctci;

import java.util.HashSet;

/**
 * Created by K on 2016-09-27.
 */
public class Question8 {

    // My solution is O(n) time and O(n) space.
    // Book solution is O(n) time and O(1) space, but I have much better constant factors.
    // Also - this one is much more readable.

    Node loopStart(Node root) {
        if (root == null) return null;
        HashSet<Node> nodes = new HashSet<>();

        Node runner = root;

        while (runner != null) {
            nodes.add(runner);
            runner = runner.next;
            if (nodes.contains(runner)) return runner;
        }

        return null;
    }
}
