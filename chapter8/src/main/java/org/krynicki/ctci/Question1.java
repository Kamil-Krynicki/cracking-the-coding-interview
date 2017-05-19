package org.krynicki.ctci;

/**
 * Created by kamil.krynicki on 19/05/2017.
 */
public class Question1 {
    long[] memo;

    public long stepCombinations(int totalSteps) {
        this.memo = new long[totalSteps + 1];
        this.memo[0] = 1;

        return stepCombinationsRec(totalSteps);
    }

    private long stepCombinationsRec(int totalSteps) {
        if(totalSteps < 0)
            return 0;

        if(memo[totalSteps] > 0)
            return memo[totalSteps];

        long result = 0;

        result += stepCombinationsRec(totalSteps - 1);
        result += stepCombinationsRec(totalSteps - 2);
        result += stepCombinationsRec(totalSteps - 3);

        return memo[totalSteps] = result;
    }
}
