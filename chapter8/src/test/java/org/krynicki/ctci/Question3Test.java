package org.krynicki.ctci;

import junit.framework.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Question3Test {

    private int testSize = 10000;
    private Question3 alg = new Question3();

    @Test
    public void regressionOverDistinctArrays() {
        for(int i =0;i<testSize;i++) {
            int[] in = randomSortedDistinctArray(new Random().nextInt(100));

            Set<Integer> bruteIndexes = bruteForceMagicIndexes(in);
            int fineIndex = alg.magicIndexAllDistinct(in);

            Assert.assertTrue(bruteIndexes.contains(fineIndex) || fineIndex == -1 && bruteIndexes.isEmpty());
        }
    }

    @Test
    public void regressionOverAllArrays() {
        for(int i =0;i< testSize;i++) {
            int[] in = randomSortedArray(new Random().nextInt(100));

            Set<Integer> bruteIndexes = bruteForceMagicIndexes(in);
            int fineIndex = alg.magicIndexRepetitions(in);

            Assert.assertTrue(bruteIndexes.contains(fineIndex) || fineIndex == -1 && bruteIndexes.isEmpty());
        }
    }

    private int[] randomSortedDistinctArray(int maxSize) {
        return new Random().ints(maxSize, -maxSize, maxSize+1).distinct().sorted().toArray();
    }

    private int[] randomSortedArray(int maxSize) {
        return new Random().ints(maxSize, -maxSize, maxSize + 1).sorted().toArray();
    }

    private Set<Integer> bruteForceMagicIndexes(int[] in) {
        Set<Integer> result = new HashSet<>();
        for(int i = 0;i<in.length;i++){
            if(in[i]==i) result.add(i);
        }
        return result;
    }

}