package org.krynicki.ctci;

import junit.framework.Assert;
import org.testng.annotations.Test;

import static org.krynicki.ctci.Question4.Listy;

public class Question4Test {
    @Test
    public void test() {
        Question4 kamil = new Question4();


        Assert.assertEquals(kamil.find(new Listy(1, 2, 3, 5), 1),0);
        Assert.assertEquals(kamil.find(new Listy(1, 2, 3, 5), 2),1);
        Assert.assertEquals(kamil.find(new Listy(1, 2, 3, 5), 3),2);
        Assert.assertEquals(kamil.find(new Listy(1, 2, 3, 5), 4),-1);
        Assert.assertEquals(kamil.find(new Listy(1, 2, 3, 5), 5),3);
        Assert.assertEquals(kamil.find(new Listy(1, 2, 4), 1),0);
        Assert.assertEquals(kamil.find(new Listy(1, 2, 4), 2),1);
        Assert.assertEquals(kamil.find(new Listy(1, 2, 4), 3),-1);
        Assert.assertEquals(kamil.find(new Listy(1, 2, 4), 4),2);
        Assert.assertEquals(kamil.find(new Listy(1, 2, 4), -1),-1);
        Assert.assertEquals(kamil.find(new Listy(), 3),-1);


        System.out.println();
    }

}