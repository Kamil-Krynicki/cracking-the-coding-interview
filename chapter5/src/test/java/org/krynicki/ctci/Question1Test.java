package org.krynicki.ctci;

import org.testng.annotations.Test;

public class Question1Test {
    @Test
    public void test() {
        Question1 kmil = new Question1();

        System.out.print(Integer.toBinaryString(kmil.replace(0b0, 0b11001, 2,7)));

    }
}