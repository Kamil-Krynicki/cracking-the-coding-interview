package org.krynicki.ctci;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by K on 2016-10-13.
 */
public class LinkedListStack<T> implements Stack<T> {
    private LinkedList<T> impl = new LinkedList<>();

    LinkedListStack(T... vals) {
        for(T val: vals) {
            this.push(val);
        }
    }

    public void shuffle() {
        Collections.shuffle(impl);
    }


    @Override
    public T pop() {
        return impl.pop();
    }

    @Override
    public T peek() {
        return impl.peek();
    }

    @Override
    public boolean isEmpty() {
        return impl.isEmpty();
    }

    @Override
    public void push(T value) {
        impl.push(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LinkedListStack<?> that = (LinkedListStack<?>) o;

        if(that.impl.size()!=this.impl.size()) {
            return false;
        }


        for(int i=0;i<that.impl.size();i++) {
            if(!that.impl.get(i).equals(this.impl.get(i))) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        return impl.hashCode();
    }
}
