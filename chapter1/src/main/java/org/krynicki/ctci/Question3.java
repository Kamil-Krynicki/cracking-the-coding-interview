package org.krynicki.ctci;

/**
 * Created by K on 2016-08-28.
 */
public class Question3 {
    char[] urlfy(char[] in, int trueSize){
        if(in == null) return new char[0];

        for(int i=trueSize-1, j=in.length-1; i>=0; i--){
            if(in[i]==' '){
                in[j--] = '0';
                in[j--] = '2';
                in[j--] = '%';
            }
            else {
                in[j--] = in[i];
            }
        }

        return in;
    }
}
