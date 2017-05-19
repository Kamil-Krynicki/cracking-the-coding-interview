package org.krynicki.ctci;

        import junit.framework.Assert;
        import org.testng.annotations.Test;

public class Question2Test {
    @Test
    public void initTests() {
        Assert.assertEquals("", new Question2().findPath(new boolean[][]{{true}}));
        Assert.assertEquals("", new Question2().findPath(new boolean[][]{{true, false}, {false, true}}));
        Assert.assertEquals("RD", new Question2().findPath(new boolean[][]{{true, true}, {true, true}}));
        Assert.assertEquals("DR", new Question2().findPath(new boolean[][]{{true, false}, {true, true}}));
        Assert.assertEquals("DDDD", new Question2().findPath(new boolean[][]{{true}, {true}, {true}, {true}, {true}}));
    }
}