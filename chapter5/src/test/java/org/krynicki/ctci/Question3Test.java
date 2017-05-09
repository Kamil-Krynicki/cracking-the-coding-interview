package org.krynicki.ctci;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.krynicki.ctci.Question3.BitFlipper;

public class Question3Test {


    @Test
    public void test() {

        Assert.assertEquals(new BitFlipper(0b11111111111111011111111111111111).flipToWin(), 32);
        Assert.assertEquals(new BitFlipper(0b0).flipToWin(), 1);
        Assert.assertEquals(new BitFlipper(0b11011101111).flipToWin(), 8);
        Assert.assertEquals(new BitFlipper(0b1100111001111).flipToWin(), 5);
        Assert.assertEquals(new BitFlipper(0b110001110001111).flipToWin(), 5);
    }

}