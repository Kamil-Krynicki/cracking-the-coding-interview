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

    // O(n^3) because of String management in Java
    // O(n^2) with a buffer / array
    public String findPath(boolean[][] field) {
        Preconditions.checkNotNull(field);

        Preconditions.checkArgument((maxY = field.length) > 0);
        Preconditions.checkArgument((maxX = field[0].length) > 0);

        this.memo = new String[maxY][maxX];
        this.field = field;

        return findPathRec(0, 0, "");
    }

    private String findPathRec(int x, int y, String steps) {
        if (!isInBounds(x, y) || !isFree(x, y))
            return "";

        if (memo[y][x] != null)
            return memo[y][x];

        String result = "";

        if (isGoal(x, y)) result = steps;
        if (result.isEmpty()) result = findPathRec(x + 1, y, steps + 'R');
        if (result.isEmpty()) result = findPathRec(x, y + 1, steps + 'D');

        return memo[y][x] = result;
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
