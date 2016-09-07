package org.krynicki.ctci;

/**
 * Created by K on 2016-09-07.
 */
public class Question3 {

    // sneaky!
    public void deleteMiddle(Node middle) {
        if (middle != null && middle.next != null) {
            middle.id = middle.next.id;
            middle.next = middle.next.next;
        }
    }
}
