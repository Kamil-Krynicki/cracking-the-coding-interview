package org.krynicki.ctci;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.*;

/**
 * Created by K on 2016-08-28.
 */
public class Question2Test {
    private static Question2 q = new Question2();

    private static String testString = "abcdefghijklmnoprqstuvxyz";

    @Test
    public void testNull() throws Exception {
        Assert.assertFalse(q.isPermutation(null, null));
        Assert.assertFalse(q.isPermutation("", null));
        Assert.assertFalse(q.isPermutation(null, ""));
    }

    @Test
    public void testEmpty() throws Exception {
        Assert.assertTrue(q.isPermutation("", ""));
        Assert.assertFalse(q.isPermutation("", "a"));
        Assert.assertFalse(q.isPermutation("a", ""));
    }

    @Test
    public void testPermutations() throws Exception {
        for(int i=0;i<100;i++){
            Assert.assertTrue(q.isPermutation(testString, permute(testString)));
        }
    }

    private String permute(String in){
        int step = new Random(System.currentTimeMillis()).nextInt(in.length()/2);

        return in.concat(in).substring(step,in.length());
    }

}