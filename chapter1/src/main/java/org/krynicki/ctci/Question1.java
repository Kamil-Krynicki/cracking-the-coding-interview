package org.krynicki.ctci;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by K on 2016-08-28.
 */

// with additional data structure
public class Question1 {
    public boolean isUnique(char[] in) {
        if(in == null) {
            return false;
        }

        if(in.length > 256) {
            return false;
        }

        boolean[] contains = new boolean[256];

        for(char c:in) {
            if(contains[c]) {
                return false;
            }
            else {
                contains[c] = true;
            }
        }

        return true;
    }

    public boolean isUniqueNoStructure(char[] in) {
        if(in == null) {
            return false;
        }

        if(in.length > 256) {
            return false;
        }

        for(int i=0;i<in.length;i++) {
            for(int j=i+1;j<in.length;j++) {
                if(in[i] == in[j]){
                    return false;
                }
            }
        }

        return true;
    }
}
