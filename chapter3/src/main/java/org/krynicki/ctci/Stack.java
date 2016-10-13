package org.krynicki.ctci;

/**
 * Created by K on 2016-10-04.
 */
public interface Stack<T> {
    T pop();
    T peek();
    boolean isEmpty();
    void push(T value);
}
