package org.krynicki.ctci;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by K on 2016-08-28.
 */
public class Question5Test extends AbstractChapter1Test {

    private  static  Question5 q = new Question5();

    @Test
    public void testNull() throws Exception {
        Assert.assertFalse(q.isOneAway(null, null));
    }

    @Test
    public void testEmpty() throws Exception {
        Assert.assertTrue(q.isOneAway(new char[0], new char[0]));
    }

    @Test
    public void testIsOneAway() throws Exception {
        char[] val1, val2;

        val1 = "kamil".toCharArray();
        val2 = "kamjl".toCharArray();

        Assert.assertTrue(q.isOneAway(val1, val2));

        val1 = "kamil".toCharArray();
        val2 = "kamilj".toCharArray();

        Assert.assertTrue(q.isOneAway(val1, val2));


        val1 = "kamilj".toCharArray();
        val2 = "kamil".toCharArray();

        Assert.assertTrue(q.isOneAway(val1, val2));

        val1 = "kamilji".toCharArray();
        val2 = "kamil".toCharArray();

        Assert.assertFalse(q.isOneAway(val1, val2));

        val1 = "kaajl".toCharArray();
        val2 = "kamil".toCharArray();

        Assert.assertFalse(q.isOneAway(val1, val2));
    }

}