package org.krynicki.ctci;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.krynicki.ctci.Question4.BitMagic;

public class Question4Test {
    private final BitMagic bitMagic = new BitMagic();

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void shouldFailOnMinLimitInSmallest() {
        bitMagic.nextSmallestSameOnes(0b0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void shouldFailOnMinLimitInLargest() {
        bitMagic.prvLargestSameOnes(0b0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void shouldFailOnMaxLimitInLargest() {
        bitMagic.prvLargestSameOnes(0b1111);
    }

    @Test
    public void shouldSucceedOnMaxLimitInSmallest() {
        Assert.assertEquals(Integer.toBinaryString(bitMagic.nextSmallestSameOnes(0b1111)), "10111");
    }

    @Test
    public void complexCase1() {
        Assert.assertEquals(Integer.toBinaryString(bitMagic.prvLargestSameOnes(0b1100111001111)), "1100110101111");
        Assert.assertEquals(Integer.toBinaryString(bitMagic.prvLargestSameOnes(0b110001110001111)), "110001101001111");
    }

    @Test
    public void complexCase2() {
        Assert.assertEquals(Integer.toBinaryString(bitMagic.nextSmallestSameOnes(0b1100111001111)), "1100111010111");
        Assert.assertEquals(Integer.toBinaryString(bitMagic.nextSmallestSameOnes(0b110001110001111)), "110001110010111");
    }
}