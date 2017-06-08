package org.krynicki.ctci;

import org.testng.annotations.Test;

public class Question11Test {

    @Test
    public void test(){
        Question11 kamil = new Question11();

        for(int i = 0;i<=100;i++){
            System.out.println("For "+i+" cents "+kamil.centCombinations(i)+" combinations");
        }

        System.out.println();
    }
}