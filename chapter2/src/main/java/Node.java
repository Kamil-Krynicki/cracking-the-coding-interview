/**
 * Created by K on 2016-09-01.
 */
public class Node {
    public int id;
    public Node next;
    public Node prv;

    public Node(int id, Node next) {
        this.id = id;
        this.next = next;
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

    @Override
    public int hashCode() {
        return id;
    }
}
