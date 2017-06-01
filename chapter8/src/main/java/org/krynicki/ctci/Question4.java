package org.krynicki.ctci;

import com.google.common.collect.Sets;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by kamil.krynicki on 01/06/2017.
 */
public class Question4 {
    public <T> Set<Set<T>> powerSet(Set<T> elements) {
        Set<Set<T>> result = Sets.<Set<T>>newHashSet(new HashSet<T>());

        if(elements.isEmpty())
            return result;

        Deque<T> elementsStack = new LinkedList<>(elements);

        while(!elementsStack.isEmpty())
            extend(result, elementsStack.pop());

        return result;
    }

    private <T> void extend(Set<Set<T>> set, T with) {
        for(Set<T> resultElement : Sets.newHashSet(set)) {
            Set<T> newResultElement = Sets.newHashSet(resultElement);
            newResultElement.add(with);
            set.add(newResultElement);
        }
    }
}
