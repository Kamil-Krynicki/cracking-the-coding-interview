package org.krynicki.ctci;

/**
 * Created by K on 2016-08-29.
 */
public class Question6 {
    public char[] compress(char[] in){
        if(in==null) return new char[0];
        if(in.length == 0) return in;

        StringBuilder sb = new StringBuilder();

        int i=1;

        int currentCount = 1;

        while(i<in.length){
            if(in[i-1]!=in[i]){
                sb.append(in[i-1]);
                sb.append(currentCount);

                if(sb.length() > in.length){
                    return in;
                }

                currentCount = 1;
            }
            else {
                currentCount++;
            }
            i++;
        }

        sb.append(in[in.length-1]);
        sb.append(currentCount);

        return sb.toString().toCharArray();
    }

}
