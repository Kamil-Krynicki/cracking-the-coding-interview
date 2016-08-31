package org.krynicki.ctci;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.testng.Assert.*;

/**
 * Created by K on 2016-08-31.
 */
public class Question8Test extends AbstractChapter1Test{
    private static Question8 q = new Question8();


    @Test
    public void testZeroMatrixCuteBase() throws Exception {
        q.zeroMatrix(null);
        q.zeroMatrix(new int[0][0]);
        q.zeroMatrix(new int[3][2]);
    }

    @Test
    public void testZeroMatrixCuteZeroing() throws Exception {
        Random rand = ThreadLocalRandom.current();
        int[][] matrix = randMatrix(rand.nextInt(10)+1, rand.nextInt(10)+1);
        Assert.assertEquals(countZeros(matrix), 0);

        q.zeroMatrix(matrix);

        Assert.assertEquals(countZeros(matrix), 0);

        matrix[rand.nextInt(matrix.length)][rand.nextInt(matrix[0].length)] = 0;

        q.zeroMatrix(matrix);

        Assert.assertEquals(countZeros(matrix), matrix.length+matrix[0].length-1);
    }

    @Test
    public void testZeroMatrixBase() throws Exception {
        q.zeroMatrixCute(null);
        q.zeroMatrixCute(new int[0][0]);
        q.zeroMatrix(new int[0][0]);
    }

    @Test
    public void testZeroMatrixBaseZeroing() throws Exception {
        Random rand = ThreadLocalRandom.current();
        int[][] matrix = randMatrix(rand.nextInt(10)+1, rand.nextInt(10)+1);
        Assert.assertEquals(countZeros(matrix), 0);

        q.zeroMatrixCute(matrix);

        Assert.assertEquals(countZeros(matrix), 0);

        matrix[rand.nextInt(matrix.length)][rand.nextInt(matrix[0].length)] = 0;
        q.zeroMatrixCute(matrix);
        Assert.assertEquals(countZeros(matrix), matrix.length+matrix[0].length-1);
    }

    @Test
    public void tesSpeed() throws Exception {
        //local experiments - cute x4 faster
        Random rand = ThreadLocalRandom.current();
        int[][] matrix = randMatrix(5000, 5000);
        Assert.assertEquals(countZeros(matrix), 0);

        long t1, t2, t3;

        t1 = System.currentTimeMillis();

        q.zeroMatrixCute(matrix);

        t2 = System.currentTimeMillis();

        q.zeroMatrix(matrix);

        t3 = System.currentTimeMillis();

        System.out.println("Empty Runs:");
        System.out.println("- cute Matrix zero:"+ (t2-t1));
        System.out.println("- norm Matrix zero:"+ (t3-t2));

        Assert.assertEquals(countZeros(matrix), 0);

        for(int i=0;i<500;i++){
            matrix[rand.nextInt(matrix.length)][rand.nextInt(matrix[0].length)] = 0;
        }

        t1 = System.currentTimeMillis();

        q.zeroMatrixCute(matrix);

        t2 = System.currentTimeMillis();

        q.zeroMatrix(matrix.clone());

        t3 = System.currentTimeMillis();

        System.out.println("Hot Runs:");
        System.out.println("- cute Matrix zero:"+ (t2-t1));
        System.out.println("- norm Matrix zero:"+ (t3-t2));
    }


    private int[][] randMatrix(int cols, int rows){
        Random rand = ThreadLocalRandom.current();
        int[][] matrix = new int[cols][rows];

        for(int i=0;i<matrix.length;i++)
            for(int j=0;j<matrix[0].length;j++){
                {
                    matrix[i][j] = rand.nextInt(100)+1;
                }
            }

        return matrix;
    }

    private int countZeros(int[][] matrix){
        int result = 0;
        for(int i=0;i<matrix.length;i++)
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    result++;
                }
            }

        return result;
    }
}