package org.krynicki.ctci;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by kamil.krynicki on 08/06/2017.
 */
public class Question8 {
    public Set<String> permutationsNoRep(String chars) {
        return permutations("", new LetterCounts(chars), new HashSet<>());
    }

    private Set<String> permutations(String prefix, LetterCounts availableChars, Set<String> resultAggregator) {
        if (availableChars.isEmpty())
            resultAggregator.add(prefix);
        else
            for (char c : availableChars)
                permutations(prefix + c, availableChars.decrease(c), resultAggregator);

        return resultAggregator;
    }

    private class LetterCounts implements Iterable<Character> {
        private final Map<Character, Long> counts;

        public LetterCounts(String in) {
            this.counts = IntStream
                    .range(0, in.length())
                    .mapToObj(in::charAt)
                    .collect(
                            Collectors.groupingBy(
                                    Function.identity(), Collectors.counting()
                            )
                    );
        }

        private LetterCounts(LetterCounts parent, Character toDecrease) {
            this.counts = new HashMap<>(parent.counts);

            long count = counts.getOrDefault(toDecrease, 0l);

            if (count > 1)
                counts.replace(toDecrease, count - 1);
            else
                counts.remove(toDecrease);
        }

        public boolean isEmpty() {
            return counts.isEmpty();
        }

        public LetterCounts decrease(char c) {
            return new LetterCounts(this, c);
        }

        @Override
        public Iterator<Character> iterator() {
            return counts.keySet().iterator();
        }
    }
}
