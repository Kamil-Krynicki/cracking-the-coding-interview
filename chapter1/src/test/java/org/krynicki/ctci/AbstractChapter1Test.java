package org.krynicki.ctci;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by K on 2016-08-29.
 */
public class AbstractChapter1Test {
    protected char[] alphabet() {
        return "abcdefghijklmnopqrstuvxyz".toCharArray();
    }


    protected char[] mixup(char[] in) {
        char[] result = in.clone();

        for (int i = 0; i < in.length; i++) {
            result[i]++;
        }

        return result;
    }

    protected char[] permute(char[] in) {
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

    protected char[] randomString() {
        Random rand = ThreadLocalRandom.current();
        int size = rand.nextInt(400) + 1;
        char[] result = new char[size];

        for (int i = 0; i < size; i++) {
            result[i] = (char) rand.nextInt(254);
        }

        return result;
    }
}
