package org.krynicki.ctci;

/**
 * Created by K on 2016-09-01.
 */
public class Question9 {
    // I knew this trick
    public boolean isRotation(String s1, String s2) {
        return s1.concat(s1).contains(s2);
    }
}
