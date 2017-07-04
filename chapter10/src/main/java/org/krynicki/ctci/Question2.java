package org.krynicki.ctci;

import java.util.Arrays;

/**
 * Created by kamil.krynicki on 04/07/2017.
 */
public class Question2 {
    void anagramSort(String[] values) {
        Arrays.sort(values, (o1, o2) -> anagramRoot(o1).compareTo(anagramRoot(o2)));
    }

    private String anagramRoot(String o1) {
        char[] a = o1.toCharArray();
        Arrays.sort(a);
        return String.valueOf(a);
    }
}
