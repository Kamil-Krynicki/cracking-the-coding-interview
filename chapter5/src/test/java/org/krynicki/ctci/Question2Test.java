package org.krynicki.ctci;

/**
 * Created by kamil.krynicki on 08/05/2017.
 */

import org.testng.annotations.Test;

public class Question2Test {
    @Test
    public void test() {
        Question2 kmil = new Question2();

        System.out.print(kmil.toBits(0.33d));

    }
}
