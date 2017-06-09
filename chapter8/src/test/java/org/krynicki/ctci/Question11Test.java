package org.krynicki.ctci;

import org.testng.annotations.Test;

public class Question11Test {

    @Test
    public void test(){
        Question11 kamil = new Question11();

        long t1 = System.currentTimeMillis();
        for(int i = 0;i<=10000;i++){
            kamil.centCombinations(1000);
            //System.out.println("For "+i+" cents "+kamil.centCombinations(i)+" combinations");
        }
        long t2 = System.currentTimeMillis();

        System.out.println(t2 - t1);
    }
}