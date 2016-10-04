package org.krynicki.ctci;

/**
 * Created by K on 2016-09-01.
 */
public class Node<T> {
    public T data;
    public Node<T> next;
    public Node<T> prv;

    public Node(T data) {
        this.data = data;
        this.next = null;
        this.prv = null;
    }

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
        this.prv = null;
    }

    public Node(T data, Node<T> next, Node<T> prv) {
        this.data = data;
        this.next = next;
        this.prv = prv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node<T> node = (Node) o;

        return data == node.data;

    }

    public boolean deepEquals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node<T> node = (Node<T>) o;

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
