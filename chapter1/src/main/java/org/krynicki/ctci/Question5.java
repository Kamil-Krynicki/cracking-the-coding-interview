package org.krynicki.ctci;

/**
 * Created by K on 2016-08-28.
 */
public class Question5 {
    boolean isOneAway(char[] in1, char[] in2) {
        if (in1 == null || in2 == null) return false;

        char[] longer = in1.length >= in2.length ? in1 : in2;
        char[] shorter = in1.length >= in2.length ? in2 : in1;

        if (longer.length - shorter.length > 1) return false;

        int shorterIndex = 0;
        int longerIndex = 0;

        boolean changeDetected = false;

        while (shorterIndex < shorter.length && longerIndex < longer.length) {
            if (shorter[shorterIndex] != longer[longerIndex]) {
                if (changeDetected) return false;

                changeDetected = true;

                if (longer.length != shorter.length) {
                    shorterIndex--; //neat trick!
                }
            }

            shorterIndex++;
            longerIndex++;
        }

        return true;
    }

}
