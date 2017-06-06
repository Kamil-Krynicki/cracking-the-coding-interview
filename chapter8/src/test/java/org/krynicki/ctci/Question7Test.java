package org.krynicki.ctci;

import junit.framework.Assert;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Question7Test {
    private Question7 alg = new Question7();

    @Test
    public void testEmpty() throws Exception {
        Assert.assertEquals(alg.permutations(""), expected(""));
    }

    @Test
    public void testSimple() throws Exception {
        Assert.assertEquals(alg.permutations("a"), expected("a"));
        Assert.assertEquals(alg.permutations("ab"), expected("ab", "ba"));
    }

    @Test
    public void testHard() throws Exception {
        Assert.assertEquals(alg.permutations("abc"), expected("abc", "acb", "bac", "bca", "cab", "cba"));
    }

    private Set<String> expected(String... in) {
        return IntStream.range(0, in.length).mapToObj(t -> in[t]).collect(Collectors.toSet());
    }
}