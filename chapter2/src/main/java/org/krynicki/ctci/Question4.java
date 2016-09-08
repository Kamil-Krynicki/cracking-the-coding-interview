package org.krynicki.ctci;

/**
 * Created by K on 2016-09-08.
 */
public class Question4 {
    // always inverts, but hey!
    public Node partition(Node root, int partition) {
        if (root == null) return null;
        Node less = null;
        Node more = null;

        Node next;

        // split
        while (root != null) {
            next = root.next;
            if (root.id >= partition) {
                root.next = more;
                more = root;
            } else {
                root.next = less;
                less = root;
            }
            root = next;
        }

        // ugly corner cases
        if (less == null) {
            return more;
        } else if (more == null) {
            return less;
        } else {
            // bind root to head
            root = less;

            // rewind less;
            while (less.next != null) {
                less = less.next;
            }

            // bind last smaller to first larger
            less.next = more;

            return root;
        }
    }
}
