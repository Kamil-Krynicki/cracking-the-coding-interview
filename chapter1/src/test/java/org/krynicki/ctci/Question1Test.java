package org.krynicki.ctci;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by K on 2016-08-28.
 */
public class Question1Test extends AbstractChapter1Test {

    private static Question1 q = new Question1();

    private static char[][] unique = {"abcdefghijklmnoprqstuvxyz".toCharArray(),
            "abcdefghijklmnoprqstuvxyz".toUpperCase().toCharArray(),
            "a".toCharArray(),
            "!@#$%^&*()_+".toUpperCase().toCharArray(),
            "$".toCharArray()};


    private static char[][] notUnique = {"abcdefghijklmnoprqsstuvxyz".toCharArray(),
            "abcdefghijdklmnoprqstuvxyz".toUpperCase().toCharArray(),
            "aa".toCharArray(),
            "!@#$%^&*()_+^".toUpperCase().toCharArray(),
            "$$".toCharArray()};


    @Test
    public void testNull() throws Exception {
        q.isUnique(null);
        q.isUniqueNoStructure(null);
    }

    @Test
    public void testEmpty() throws Exception {
        Assert.assertTrue(q.isUnique(new char[0]));
        Assert.assertTrue(q.isUniqueNoStructure(new char[0]));
    }

    @Test
    public void testIsUnique() throws Exception {
        for(char[] cs:unique) {
            Assert.assertTrue(q.isUnique(cs));
            Assert.assertTrue(q.isUniqueNoStructure(cs));
        }
    }

    @Test
    public void testIsNotUnique() throws Exception {
        for(char[] cs:notUnique) {
            Assert.assertFalse(q.isUnique(cs));
            Assert.assertFalse(q.isUniqueNoStructure(cs));
        }
    }

    @Test
    public void testGeneral() throws Exception {

        char[] value;

        for(int i=0;i<100;i++) {
            value = randomString();

            Assert.assertEquals(q.isUnique(value), q.isUniqueNoStructure(value));
        }
    }

}