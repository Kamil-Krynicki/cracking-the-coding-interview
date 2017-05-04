package org.krynicki.ctci;

import org.testng.annotations.Test;

public class Question1Test {
    @Test
    public void test() {
        Question1 kmil = new Question1();

        System.out.print(Integer.toBinaryString(kmil.replace((byte) 0b10101010, (byte) 0b11001, 1, 6) & 0xFF));

    }
}