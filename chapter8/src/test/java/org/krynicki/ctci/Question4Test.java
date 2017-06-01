package org.krynicki.ctci;

import junit.framework.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class Question4Test {

    private Question4 alg = new Question4();

    @Test
    public void sizeTests() {
        Set<Integer> set = new HashSet<>();
        int size = 1;
        for(int i=0;i<15;i++) {
            Assert.assertEquals(alg.powerSet(set).size(), size);
            set.add(i);
            size*=2;
        }
    }
}