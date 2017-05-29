package org.krynicki.ctci;

import com.google.common.base.Preconditions;

/**
 * Created by kamil.krynicki on 19/05/2017.
 */
public class Question2 {
    private String[][] memo;
    private boolean[][] field;

    private int maxY;
    private int maxX;

    // O(n^2)
    public String findPath(boolean[][] field) {
        Preconditions.checkNotNull(field);

        Preconditions.checkArgument((maxY = field.length) > 0);
        Preconditions.checkArgument((maxX = field[0].length) > 0);

        this.memo = new String[maxY][maxX];
        this.field = field;

        return findPathFrom(0, 0);
    }

    private String findPathFrom(int x, int y) {
        if (!isInBounds(x, y) || !isFree(x, y))
            return null;

        if (memo[y][x] != null)
            return memo[y][x];

        if (isGoal(x, y))
            return memo[y][x] = "";

        String result;

        result = findPathFrom(x + 1, y);

        if(isValid(result))
            return memo[y][x] = "R" + result;

        result = findPathFrom(x, y + 1);

        if(isValid(result))
            return memo[y][x] = "D" + result;

        return null;
    }

    private boolean isValid(String result) {
        return result!=null;
    }

    private boolean isGoal(int x, int y) {
        return x == maxX - 1 && y == maxY - 1;
    }

    private boolean isFree(int x, int y) {
        return field[y][x];
    }

    private boolean isInBounds(int x, int y) {
        return x < maxX && y < maxY;
    }
}
