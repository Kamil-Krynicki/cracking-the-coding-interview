package org.krynicki.ctci;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.krynicki.ctci.Question4.BitMagic;

public class Question4Test {
    private final BitMagic bitMagic = new BitMagic();

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void shouldFailOnMinLimitInSmallest() {
        bitMagic.nextSmallestSameOnes2(0b0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void shouldFailOnMinLimitInLargest() {
        bitMagic.prvLargestSameOnes2(0b0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void shouldFailOnMaxLimitInLargest() {
        bitMagic.prvLargestSameOnes2(0b1111);
    }

    @Test
    public void shouldSucceedOnMaxLimitInSmallest() {
        Assert.assertEquals(Integer.toBinaryString(bitMagic.nextSmallestSameOnes2(0b1111)), "10111");
    }

    @Test
    public void complexCase4() {
        Assert.assertEquals(Integer.toBinaryString(bitMagic.prvLargestSameOnes2(0b111001111)), "110111110");
        Assert.assertEquals(Integer.toBinaryString(bitMagic.prvLargestSameOnes2(0b110001110001111)), "110001101111100");
    }

    @Test
    public void complexCase3() {
        Assert.assertEquals(Integer.toBinaryString(bitMagic.nextSmallestSameOnes2(0b1001111000)), "1010000111");
        Assert.assertEquals(Integer.toBinaryString(bitMagic.nextSmallestSameOnes2(0b1001111110)), "1010011111");
    }
}