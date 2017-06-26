package org.krynicki.ctci;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by kamil.krynicki on 06/06/2017.
 */
public class Question9 {

    private static final String F_PAREN = "()";
    private static final String L_PAREN = "(";
    private static final String R_PAREN = ")";

    public void printParenthesis(int n) {
        if (n > 0)
            //System.out.print(pars("", n, 0, new HashSet<>()));
            //System.out.print(pars(n));
    }

    // FASTER
    public Set<String> pars(int n) {
        if (n == 1)
            return Collections.singleton(F_PAREN);

        Set<String> result = new HashSet<>();

        for (String par : pars(n - 1)) {
            result.add(F_PAREN + par);
            result.add(par + F_PAREN);
            result.add(L_PAREN + par + R_PAREN);
        }

        return result;
    }

    // SLOWER!
    public Set<String> pars(String prefix, int toOpen, int open, Set<String> result) {
        if (toOpen == 0 && open == 0) {
            result.add(prefix);
        } else {
            if (toOpen > 0) {
                result.addAll(pars(prefix+ L_PAREN, toOpen - 1, open + 1, result));
            }

            if (open > 0) {
                result.addAll(pars(prefix+ R_PAREN, toOpen, open - 1, result));
            }
        }


        return result;
    }
}
