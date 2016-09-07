package org.krynicki.ctci;

import org.testng.annotations.Test;

/**
 * Created by K on 2016-08-29.
 */
public class Question7Test extends AbstractChapter1Test {

    private static Question7 q = new Question7();


    @Test
    public void testRotate() throws Exception {
        q.rotate(null);
        q.rotate(new int[0][0]);
        q.rotate(new int[2][3]);


        int[][] matrix = new int[][]{{1, 2, 3}, {3, 5, 8}, {4, 6, 9}};
        int[][] matrix2 = q.rotate(matrix);


    }

}