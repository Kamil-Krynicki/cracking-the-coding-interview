package org.krynicki.ctci;

import org.testng.annotations.Test;

import static org.krynicki.ctci.Question8.Screen;

public class Question8Test {

    @Test
    public void shouldWorkFine1a() {
        new Screen().drawLine(new byte[]{0, 0}, 16, 0, 7, 0);
        new Screen().drawLine(new byte[]{0, 0}, 16, 1, 7, 0);
        new Screen().drawLine(new byte[]{0, 0}, 16, 2, 7, 0);
        new Screen().drawLine(new byte[]{0, 0}, 16, 3, 7, 0);
        new Screen().drawLine(new byte[]{0, 0}, 16, 4, 7, 0);
        new Screen().drawLine(new byte[]{0, 0}, 16, 5, 7, 0);
        new Screen().drawLine(new byte[]{0, 0}, 16, 6, 7, 0);
        new Screen().drawLine(new byte[]{0, 0}, 16, 7, 7, 0);
    }

    @Test
    public void shouldWorkFine1b() {
        new Screen().drawLine(new byte[]{0, 0}, 16, 0, 0, 0);
        new Screen().drawLine(new byte[]{0, 0}, 16, 0, 1, 0);
        new Screen().drawLine(new byte[]{0, 0}, 16, 0, 2, 0);
        new Screen().drawLine(new byte[]{0, 0}, 16, 0, 3, 0);
        new Screen().drawLine(new byte[]{0, 0}, 16, 0, 4, 0);
        new Screen().drawLine(new byte[]{0, 0}, 16, 0, 5, 0);
        new Screen().drawLine(new byte[]{0, 0}, 16, 0, 6, 0);
        new Screen().drawLine(new byte[]{0, 0}, 16, 0, 7, 0);
    }

    @Test
    public void shouldWorkFine2() {
        new Screen().drawLine(new byte[]{0, 0}, 16, 5, 8, 0);
    }

    @Test
    public void shouldWorkFine3() {
        new Screen().drawLine(new byte[]{0, 0}, 16, 0, 7, 0);
    }

    @Test
    public void shouldWorkFine4() {
        new Screen().drawLine(new byte[]{0, 0}, 16, 0, 15, 0);
    }

    @Test
    public void shouldWorkFine5() {
        new Screen().drawLine(new byte[]{0, 0}, 16, 1, 14, 0);
    }
}