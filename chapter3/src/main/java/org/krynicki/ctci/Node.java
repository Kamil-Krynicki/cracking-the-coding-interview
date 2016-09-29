package org.krynicki.ctci;

/**
 * Created by K on 2016-09-01.
 */
public class Node {
    public Object data;
    public Node next;
    public Node prv;

    public Node(Object data) {
        this.data = data;
        this.next = null;
        this.prv = null;
    }

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
        this.prv = null;
    }

    public Node(Object data, Node next, Node prv) {
        this.data = data;
        this.next = next;
        this.prv = prv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        return data == node.data;

    }

    public boolean deepEquals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        return data == node.data && next == null ? node.next == null : next.equals(node.next);

    }

    public String deepToString() {
        return "[" + data + "]" + (this.next == null ? "" : "->" + this.next.deepToString());
    }

    @Override
    public int hashCode() {
        return data.hashCode();
    }
}
