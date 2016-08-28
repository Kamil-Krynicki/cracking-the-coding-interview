package org.krynicki.ctci;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.*;

/**
 * Created by K on 2016-08-28.
 */
public class Question4Test {

    private static Question4 q = new Question4();

    @Test
    public void testNull() throws Exception {
        Assert.assertFalse(q.isPermutationOfPalindrome(null));
    }

    @Test
    public void testEmpty() throws Exception {
        Assert.assertFalse(q.isPermutationOfPalindrome(""));
    }

    @Test
    public void testIsPermutation() throws Exception {
        Assert.assertTrue(q.isPermutationOfPalindrome("Tact Coa"));
    }

}