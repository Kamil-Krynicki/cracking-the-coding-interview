package org.krynicki.ctci;

import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kamil.krynicki on 27/06/2017.
 */
public class Question14 {
    private Map<String, Map<Boolean, Integer>> memo;

    public int countPar(String expression, boolean value) {
        this.memo = new HashMap<>();

        this.memo.put("", ImmutableMap.of(true, 0, false, 0)); // safeguard
        this.memo.put("1", ImmutableMap.of(true, 1, false, 0));
        this.memo.put("0", ImmutableMap.of(true, 0, false, 1));

        return innerCountPar(expression, value);
    }

    private int innerCountPar(String expr, boolean value) {
        if (!memo.containsKey(expr)) {
            int totalCombinations = 0;
            int trueCombinations = 0;

            for (int i = 1; i < expr.length() - 1; i++) {
                char operand = expr.charAt(i);
                if (isOperand(operand)) {
                    String left = expr.substring(0, i);
                    String right = expr.substring(i + 1);

                    int lTrue = innerCountPar(left, true);
                    int rTrue = innerCountPar(right, true);
                    int lFalse = innerCountPar(left, false);
                    int rFalse = innerCountPar(right, false);

                    trueCombinations += totalTrue(operand, lTrue, rTrue, lFalse, rFalse);
                    totalCombinations += total(lTrue, rTrue, lFalse, rFalse);
                }
            }

            memo.put(expr, ImmutableMap.of(true, trueCombinations, false, totalCombinations - trueCombinations));
        }

        return memo.get(expr).get(value);
    }

    private int total(int lTrue, int rTrue, int lFalse, int rFalse) {
        return (lTrue + lFalse) * (rTrue + rFalse);
    }

    private int totalTrue(char operand, int lTrue, int rTrue, int lFalse, int rFalse) {
        switch (operand) {
            case '&':
                return lTrue * rTrue;
            case '|':
                return lTrue * rTrue + lFalse * rTrue + lTrue * rFalse;
            case '^':
                return lFalse * rTrue + lTrue * rFalse;
        }
        return 0;
    }

    private boolean isOperand(char expression) {
        return !isValue(expression);
    }

    private boolean isValue(char expression) {
        return "10".contains(String.valueOf(expression));
    }
}
