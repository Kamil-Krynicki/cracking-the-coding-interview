package org.krynicki.ctci;

/**
 * Created by K on 2016-08-28.
 */
public class Question5 {
    boolean isOneAway(char[] in1, char[] in2) {
        if(in1 == null || in2 == null) return false;

        char[] longer = in1.length>=in2.length? in1: in2;
        char[] shorter = in1.length>=in2.length? in2: in1;

        if(longer.length-shorter.length > 1) return false;

        if(longer.length == shorter.length) {
            boolean changeDetected = false;

            for(int i=0; i< in1.length; i++) {
                if(in1[i]!=in2[i]){
                    if(!changeDetected) {
                        changeDetected = true;
                    }
                    else {
                        return false;
                    }
                }
            }
        }
        else {
            int letterFound = 0;

            for(int i=0; i< shorter.length; i++) {
                if(shorter[i]!=longer[i + letterFound]){
                    if(i==0) {
                        i++;
                    }
                    else {
                        return false;
                    }
                }
            }
        }

        return true;
    }

}
