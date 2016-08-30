package org.krynicki.ctci;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.junit.ArrayAsserts;

import static org.testng.Assert.*;

/**
 * Created by K on 2016-08-29.
 */
public class Question6Test extends AbstractChapter1Test {

    private static Question6 q = new Question6();

    @Test
    public void testCompress() throws Exception {
        q.compress(null);
        q.compress(new char[0]);

        for(int i=0;i < 100; i++){
            q.compress(randomString());
        }

        Assert.assertEquals(q.compress(alphabet()), alphabet());

        ArrayAsserts.assertArrayEquals(q.compress("aabcccccaaa".toCharArray()), "a2b1c5a3".toCharArray() );
        ArrayAsserts.assertArrayEquals(q.compress("aAbccCcCaaa".toCharArray()), "aAbccCcCaaa".toCharArray());
    }

}