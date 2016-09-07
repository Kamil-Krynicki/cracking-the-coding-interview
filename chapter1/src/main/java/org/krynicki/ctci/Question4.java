package org.krynicki.ctci;

/**
 * Created by K on 2016-08-28.
 */
public class Question4 {
    boolean isPermutationOfPalindrome(String in) {
        if (in == null) return false;

        in = in.toLowerCase();
        in = in.replaceAll("\\s", "");

        if (in.length() == 0) return false;

        int[] counts = new int[256];

        for (char c : in.toCharArray()) {
            counts[c]++;
        }

        boolean foundOddCount = false;

        for (int i : counts) {
            if (i % 2 != 0) {
                if (!foundOddCount) {
                    foundOddCount = true;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
