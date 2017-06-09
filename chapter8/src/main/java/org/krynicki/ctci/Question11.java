package org.krynicki.ctci;

import java.util.Arrays;

/**
 * Created by kamil.krynicki on 08/06/2017.
 */
public class Question11 {

    private static int[] coins = {25, 10, 5, 1};
    private int[][] memo;

    public int centCombinations(int cents) {
        this.memo = new int[cents + 1][coins.length - 1];
        Arrays.fill(this.memo[0], 1);
        return centCombinations(cents, 0);
    }

    private int centCombinations(int cents, int coin) {
        if (cents < 0)
            return 0;

        if (coins[coin] == 1)
            return 1;

        if (memo[cents][coin] == 0) {
            int c = cents;
            do {
                memo[cents][coin] += centCombinations(c, coin + 1);
            } while ((c -= coins[coin]) >= 0);
        }

        return memo[cents][coin];
    }
}
