package org.krynicki.ctci;

/**
 * Created by K on 2016-08-30.
 */
public class Question8 {

    // O(1) space, O(n*n) time (v.low constant factor), lower constant factor than then non-cute version,
    // but "hacky" and has a 1 in 2^32 chance of failure.

    public int[][] zeroMatrixCute(int[][] matrix) {
        if (matrix == null) return null;
        if (matrix.length == 0) return matrix;

        boolean change = false;

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                if (matrix[i][j] == 0) {
                    setColumn(matrix, j, Integer.MIN_VALUE);
                    setRow(matrix, i, Integer.MIN_VALUE);
                    change = true;
                }

        if(change){
            for (int i = 0; i < matrix.length; i++)
                for (int j = 0; j < matrix[0].length; j++)
                    if (matrix[i][j] == Integer.MIN_VALUE) {
                        matrix[i][j] = 0;
                    }
        }


        return matrix;
    }

    private void setColumn(int[][] matrix, int column, int val){
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][column] = val;
        }
    }

    private void setRow(int[][] matrix, int row, int val){
        for (int i = 0; i < matrix[row].length; i++) {
            matrix[row][i] = val;
        }
    }

    //O(n) space, O(n*n) time
    public int[][] zeroMatrix(int[][] matrix) {
        if (matrix == null) return null;
        if (matrix.length == 0) return matrix;

        boolean[] colsToZero = new boolean[matrix.length];
        boolean[] rowsToZero = new boolean[matrix[0].length];

        try {

            for (int i = 0; i < matrix.length; i++)
                for (int j = 0; j < matrix[0].length; j++)
                    if (matrix[i][j] == 0) {
                        colsToZero[i] = true;
                        rowsToZero[j] = true;
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
        }
        catch (Exception e){
            System.out.print("");
        }

        return matrix;
    }
}
