package org.krynicki.ctci;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by K on 2016-08-28.
 */
public class Question4Test extends AbstractChapter1Test {

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