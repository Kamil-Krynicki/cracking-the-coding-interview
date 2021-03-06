package org.krynicki.ctci;

/**
 * Created by K on 2016-09-01.
 */
public class Node {
    public int id;
    public Node next;
    public Node prv;

    public Node(int id) {
        this.id = id;
        this.next = null;
        this.prv = null;
    }

    public Node(int id, Node next) {
        this.id = id;
        this.next = next;
        this.prv = null;
    }

    public Node(int id, Node next, Node prv) {
        this.id = id;
        this.next = next;
        this.prv = prv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        return id == node.id;

    }

    public boolean deepEquals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        return id == node.id && next == null ? node.next == null : next.equals(node.next);

    }

    public String deepToString() {
        return "[" + id + "]" + (this.next == null ? "" : "->" + this.next.deepToString());
    }

    @Override
    public int hashCode() {
        return id;
    }
}
