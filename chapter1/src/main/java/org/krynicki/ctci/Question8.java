package org.krynicki.ctci;

/**
 * Created by K on 2016-08-30.
 */
public class Question8 {

    //O(n) space, O(n*n) time
    int[][] zeroMatrix(int[][] matrix) {
        if (matrix == null) return null;
        if (matrix.length == 0) return matrix;

        boolean[] colsToZero = new boolean[matrix.length];
        boolean[] rowsToZero = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                if (matrix[i][j] == 0) {
                    colsToZero[j] = true;
                    rowsToZero[i] = true;
                }

        for (int i = 0; i < rowsToZero.length; i++) {
            if (rowsToZero[i]) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        for (int i = 0; i < colsToZero.length; i++) {
            if (colsToZero[i]) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        return matrix;
    }
}
