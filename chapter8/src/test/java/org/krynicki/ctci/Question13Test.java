package org.krynicki.ctci;

import com.google.common.collect.Lists;
import junit.framework.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.krynicki.ctci.Question13.Box;

public class Question13Test {

    private Question13 alg = new Question13();

    @Test
    public void simpleBoxSelection() throws Exception {
        List<Box> boxes = Lists.newArrayList(box(2, 3, 2), box(1, 3, 2));

        Collections.shuffle(boxes);

        Assert.assertEquals(alg.maxHeight(boxes), 2);
    }

    @Test
    public void smallStack() throws Exception {
        List<Box> boxes = Lists.newArrayList(box(2, 3, 2), box(1, 2, 3), box(2, 2, 1));

        Collections.shuffle(boxes);

        Assert.assertEquals(alg.maxHeight(boxes), 4);
    }

    @Test
    public void medStack() throws Exception {
        List<Box> boxes = Lists.newArrayList(box(1, 1, 1), box(2, 4, 2), box(1, 2, 3), box(3, 4, 4),
                box(2, 2, 2));

        Collections.shuffle(boxes);

        Assert.assertEquals(alg.maxHeight(boxes), 6);
    }

    private Box box(int h, int w, int d) {
        return new Box(h, w, d);
    }

}