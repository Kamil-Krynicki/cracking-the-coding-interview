package org.krynicki.ctci;

/**
 * Created by K on 2016-09-15.
 */
public class Question7 {

    // I feel like this is the best one can do:
    // O(n) with 2 full runs over each list (worst case)

    // This seems to be a very cool solution!
    public Node intersection(Node list1, Node list2) {
        if (list1 == null || list2 == null) return null;

        int size1 = size(list1);
        int size2 = size(list2);

        list1 = fastForward(list1, size1 - size2);
        list2 = fastForward(list2, size2 - size1);

        while (list1 != list2) {
            list1 = list1.next;
            list2 = list2.next;
        }
        return list1;
    }

    private Node fastForward(Node list, int i) {
        if (i <= 0) return list;
        while (i-- > 0) {
            list = list.next;
        }
        return list;
    }

    private int size(Node list) {
        int result = 0;
        while (list != null) {
            list = list.next;
            result++;
        }
        return result;
    }
}
