package org.krynicki.ctci;

/**
 * Created by K on 2016-08-29.
 */
public class Question7 {
    int[][] rotate(int[][] matrix){
        if(matrix == null) return new int[0][0];
        if(matrix.length == 0) return new int[0][0];
        if(matrix.length != matrix[0].length) return matrix;

        return innerRotate(matrix, 0, matrix.length);
    }

    int[][] innerRotate(int[][] matrix, int level, int N){

        if(N<2*level) return matrix;

        int tmp;
        for(int i=level;i<N-level-1;i++){
            tmp = matrix[level][i];
            matrix[level][i] = matrix[N-i][level];
            matrix[N-i][level] = matrix[N-i][N-level];
            matrix[N-i][N-level] = matrix[N-level][N-i];
            matrix[N-level][N-i] = tmp;
        }

        innerRotate(matrix, level+1, N);

        return matrix;
    }
}
