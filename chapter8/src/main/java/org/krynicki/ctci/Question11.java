package org.krynicki.ctci;

/**
 * Created by kamil.krynicki on 08/06/2017.
 */
public class Question11 {

    private static int[] coins = {1, 5, 10, 25};
    private long[] memo;

    public long centCombinations(int n) {
        this.memo = new long[n + 1];
        this.memo[0] = 1;
        return centCombinationsRec(n);
    }

    private long centCombinationsRec(int n) {
        if (n < 0)
            return 0;

        if (memo[n] == 0)
            for (int coin : coins)
                memo[n] += centCombinationsRec(n - coin);

        return memo[n];
    }
}
