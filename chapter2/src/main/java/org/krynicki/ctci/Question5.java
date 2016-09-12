package org.krynicki.ctci;

/**
 * Created by K on 2016-09-12.
 */
public class Question5 {

    // vals backwards.
    // destruction of inputs, but nice code
    Node sum(Node val1, Node val2) {
        // edge conditions
        if (val1 == null) return val2;
        if (val2 == null) return val1;


        Node tmp = new Node(-1);
        Node result = tmp;

        // sum without worrying about carryover
        while (val1 != null && val2 != null) {
            tmp.next = new Node(val1.id + val2.id);
            val1 = val1.next;
            val2 = val2.next;
            tmp = tmp.next;
        }

        // bind whatever remains
        if (val1 == null) tmp.next = val2;
        if (val2 == null) tmp.next = val1;


        // carryover
        tmp = result;
        while (tmp.next != null) {
            if (tmp.id > 9) {
                tmp.id -= 10;
                tmp.next.id++;
            }
            tmp = tmp.next;
        }

        //potentially extend the number
        if (tmp.id > 9) {
            tmp.id -= 10;
            tmp.next = new Node(1);
        }

        return result.next;
    }
}
