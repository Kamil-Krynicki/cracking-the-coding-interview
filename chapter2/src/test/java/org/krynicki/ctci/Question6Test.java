package org.krynicki.ctci;

import org.omg.CosNaming.NamingContextPackage.AlreadyBoundHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by K on 2016-09-14.
 */
public class Question6Test extends AbstractChapter2Test{

    Question6 q = new Question6();
    @Test
    public void testBase() throws Exception {
        Assert.assertFalse(q.isPalindrome(null));
        Assert.assertTrue(q.isPalindrome(getNodeList(0)));
        Assert.assertTrue(q.isPalindrome(getNodeList(2)));
        Assert.assertTrue(q.isPalindrome(getNodeList(0, 0)));
        Assert.assertTrue(q.isPalindrome(getNodeList(2, 2)));

        Assert.assertFalse(q.isPalindrome(getNodeList(1, 0)));
        Assert.assertFalse(q.isPalindrome(getNodeList(0, 1)));

        Assert.assertTrue(q.isPalindrome(getNodeList(1, 1, 1)));
        Assert.assertTrue(q.isPalindrome(getNodeList(1, 2, 1)));
        Assert.assertTrue(q.isPalindrome(getNodeList(3, 0, 3)));
        Assert.assertFalse(q.isPalindrome(getNodeList(1, 2, 3)));
        Assert.assertFalse(q.isPalindrome(getNodeList(2, 3, 3)));

        Assert.assertTrue(q.isPalindrome(getNodeList(1, 1, 1, 1)));
        Assert.assertTrue(q.isPalindrome(getNodeList(1, 2, 2, 1)));
        Assert.assertTrue(q.isPalindrome(getNodeList(3, 0, 0, 3)));
        Assert.assertFalse(q.isPalindrome(getNodeList(1, 2, 3, 4)));
        Assert.assertFalse(q.isPalindrome(getNodeList(2, 3, 3, 5)));
    }

}