package org.krynicki.ctci;

/**
 * Created by K on 2016-09-05.
 */
public class AbstractChapter2Test {
    public Node getNodeList(int... in) {
        Node head = null;
        for (int i = in.length - 1; i >= 0; i--) {
            head = new Node(in[i], head);
        }
        return head;
    }
}
