package org.krynicki.ctci;

import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static org.testng.Assert.*;

/**
 * Created by K on 2016-08-28.
 */
public class Question2Test {
    private static Question2 q = new Question2();

    @Test
    public void testNull() throws Exception {
        Assert.assertFalse(q.isPermutationNonDestructive(null, null));
        Assert.assertFalse(q.isPermutationNonDestructive("".toCharArray(), null));
        Assert.assertFalse(q.isPermutationNonDestructive(null, "".toCharArray()));

        Assert.assertFalse(q.isPermutationDestructive(null, null));
        Assert.assertFalse(q.isPermutationDestructive("".toCharArray(), null));
        Assert.assertFalse(q.isPermutationDestructive(null, "".toCharArray()));


    }

    @Test
    public void testEmpty() throws Exception {
        Assert.assertTrue(q.isPermutationNonDestructive("".toCharArray(), "".toCharArray()));
        Assert.assertFalse(q.isPermutationNonDestructive("".toCharArray(), "a".toCharArray()));
        Assert.assertFalse(q.isPermutationNonDestructive("a".toCharArray(), new char[0]));

        Assert.assertTrue(q.isPermutationDestructive("".toCharArray(), "".toCharArray()));
        Assert.assertFalse(q.isPermutationDestructive("".toCharArray(), "a".toCharArray()));
        Assert.assertFalse(q.isPermutationDestructive("a".toCharArray(), new char[0]));


    }

    @Test
    public void testPermutations() throws Exception {
        char[] value;
        for(int i=0;i<100;i++){
            value = randomString();
            Assert.assertTrue(q.isPermutationNonDestructive(value, permute(value)));
        }

        for(int i=0;i<100;i++){
            value = randomString();
            Assert.assertTrue(q.isPermutationDestructive(value, permute(value)));
        }

        for(int i=0;i<100;i++){
            value = randomString();
            Assert.assertFalse(q.isPermutationNonDestructive(value, mixup(value)));
        }

        for(int i=0;i<100;i++){
            value = randomString();
            Assert.assertFalse(q.isPermutationDestructive(value, mixup(value)));
        }
    }

    private char[] mixup(char[] in){
        char[] result = in.clone();

        for (int i = 0; i < in.length; i++) {
            result[i]++;
        }

        return result;
    }

    private char[] permute(char[] in){
        char[] result = in.clone();
        Random rand = ThreadLocalRandom.current();
        char tmp;
        int index;

        for (int i = in.length - 1; i > 0; i--) {
            index = rand.nextInt(i + 1);
            tmp = result[index];
            result[index] = result[i];
            result[i] = tmp;
        }

        return result;
    }

    private char[] randomString(){
        Random rand = ThreadLocalRandom.current();
        int size = rand.nextInt(400) + 1;
        char[] result = new char[size];

        for(int i=0;i<size;i++) {
            result[i] = (char) rand.nextInt(254);
        }

        return result;
    }

}