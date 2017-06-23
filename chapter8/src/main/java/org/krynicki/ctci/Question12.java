package org.krynicki.ctci;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by kamil.krynicki on 23/06/2017.
 */
public class Question12 {
    public List<int[]> placeQueens(int n) {
        List<int[]> results = Lists.newArrayList();

        placeQueens(0, emptyOccupiedRow(n), results);

        return results;
    }

    private void placeQueens(int y, int[] queens, List<int[]> accumulator) {
        if (isValid(queens)) {
            accumulator.add(Arrays.copyOf(queens, queens.length));
        } else {
            for (int x = 0; x < queens.length; x++) {
                if (isAvailable(x, y, queens)) {
                    queens[x] = y;

                    placeQueens(y + 1, queens, accumulator);

                    queens[x] = Integer.MIN_VALUE;
                }
            }
        }
    }

    private int[] emptyOccupiedRow(int n) {
        int[] occupied = new int[n];
        Arrays.fill(occupied, Integer.MIN_VALUE);
        return occupied;
    }

    boolean isAvailable(int x, int y, int[] queens) {
        if(queens[x] >= 0)
            return false;

        for (int oX = 0; oX < queens.length; oX++)
            if (queens[oX] - y == oX - x || y - queens[oX] == oX - x)
                return false;

        return true;
    }

    boolean isValid(int[] result) {
        for (int i : result)
            if (i < 0)
                return false;

        return true;
    }

    String visualize(int[] occupied) {
        StringBuilder result = new StringBuilder("\n");

        for(int x = 0; x < 8; x++) {
            result.append("|");

            for (int y = 0; y < 8; y++)
                result.append("|").append(occupied[y] == x ? 'Q' : ' ');

            result.append("||\n");
        }

        return result.toString();
    }
}
