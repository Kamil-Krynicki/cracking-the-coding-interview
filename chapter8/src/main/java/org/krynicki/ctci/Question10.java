package org.krynicki.ctci;

import java.awt.Color;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by kamil.krynicki on 07/06/2017.
 */
public class Question10 {
    private Color[][] screen;
    private Color oldColor;
    private Color newColor;

    private Deque<Integer> xToDo = new LinkedList<>();
    private Deque<Integer> yToDo = new LinkedList<>();


    public Color[][] fill(int atX, int atY, Color newColor, Color[][] screen) {
        if (!isValid(atX, atY)) throw new IllegalArgumentException();

        this.screen = screen;
        this.oldColor = color(atX, atY);
        this.newColor = newColor;

        xToDo.push(atX);
        yToDo.push(atY);

        while (hasMore()) {
            int x = xToDo.pop();
            int y = yToDo.pop();

            exploreTo(x + 1, y);
            exploreTo(x, y + 1);
            exploreTo(x - 1, y);
            exploreTo(x, y - 1);
        }

        return screen;
    }

    private boolean hasMore() {
        return !xToDo.isEmpty() && !yToDo.isEmpty();
    }

    private void exploreTo(int x, int y) {
        if (isValid(x, y) && oldColor.equals(color(x, y))) {
            screen[x][y] = newColor;

            xToDo.push(x);
            yToDo.push(y);
        }
    }

    private boolean isValid(int x, int y) {
        return x < screen.length && y < screen[0].length && x >= 0 && y >= 0;
    }

    private Color color(int x, int y) {
        return screen[x][y];
    }
}
