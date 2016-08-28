package org.krynicki.ctci;

/**
 * Created by K on 2016-08-28.
 */
public class Question2 {
    boolean isPermutation(String string1, String string2){
        if(string1==null || string2 == null) return false;
        if(string1.length() == 0 ^ string2.length() == 0) return false;

        return (string1.concat(string1)).contains(string2);
    }
}
