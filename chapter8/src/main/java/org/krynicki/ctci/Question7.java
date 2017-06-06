package org.krynicki.ctci;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by kamil.krynicki on 02/06/2017.
 */
public class Question7 {
    public Set<String> permutations(String chars) {
        return permutations("",  extractLetters(chars), new HashSet<>());
    }

    private Set<String> permutations(String prefix,  Set<Character> availableChars, Set<String> resultAggregator) {
        if (availableChars.isEmpty())
            resultAggregator.add(prefix);
        else {
            for (Character c : new HashSet<>(availableChars)) {
                availableChars.remove(c);
                permutations(prefix + c, availableChars, resultAggregator);
                availableChars.add(c);
            }
        }

        return resultAggregator;
    }

    private Set<Character> extractLetters(String chars) {
        return IntStream
                .range(0, chars.length())
                .mapToObj(chars::charAt)
                .distinct()
                .collect(Collectors.toSet());
    }
}
