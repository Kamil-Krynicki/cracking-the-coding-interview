package org.krynicki.ctci;

import java.util.Arrays;

/**
 * Created by K on 2016-08-28.
 */
public class Question2 {
    boolean isPermutationDestructive(char[] string1, char[] string2){
        if(string1==null || string2 == null) return false;

        if(string1.length!=string2.length) return false;

        Arrays.sort(string1);
        Arrays.sort(string2);

        for(int i=0;i<string1.length;i++){
            if(string1[i]!=string2[i]) return false;
        }

        return true;
    }

    boolean isPermutationNonDestructive(char[] string1, char[] string2){
        if(string1==null || string2 == null) return false;
        if(string1.length!=string2.length) return false;

        int[] counters = new int[256];

        for(int i=0;i<string1.length;i++){
            counters[string1[i]]++;
        }

        for(int i=0;i<string2.length;i++){
            counters[string2[i]]--;
        }

        for(int i:counters){
            if(i!=0) return false;
        }

        return true;
    }
}
