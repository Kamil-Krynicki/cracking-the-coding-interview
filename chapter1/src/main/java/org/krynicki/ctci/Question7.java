package org.krynicki.ctci;

/**
 * Created by K on 2016-08-29.
 */
public class Question7 {
    public int[][] rotate(int[][] matrix){
        //rotates right
        if(matrix == null) return new int[0][0];
        if(matrix.length == 0) return new int[0][0];
        if(matrix.length != matrix[0].length) return matrix;

        innerRotate(matrix, 0, matrix.length);

        return matrix;
    }

   private void innerRotate(int[][] matrix, int level, int N){

        if(N<2*level) return;

        int tmp;
        for(int i=level;i<N-level-1;i++){
            tmp = matrix[level][i];
            matrix[level][i] = matrix[N-i-1][level];
            matrix[N-i-1][level] = matrix[N-level-1][N-i-1];
            matrix[N-level-1][N-i-1] = matrix[i][N-level-1];
            matrix[i][N-level-1] = tmp;
        }

        innerRotate(matrix, level+1, N);
    }
}
