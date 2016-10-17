package org.krynicki.ctci;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by K on 2016-10-10.
 */
public class Question4 {
    static class MyQueue<T> {
        private Deque<T> leftStack;
        private Deque<T> rightStack;

        public MyQueue() {
            leftStack = new LinkedList<>();
            rightStack = new LinkedList<>();
        }

        public void enqueque(T item) {
            transfer(leftStack, rightStack);

            rightStack.push(item);
        }

        public T dequeue() {
            transfer(rightStack, leftStack);

            return leftStack.pop();
        }

        private void transfer(Deque<T> from, Deque<T> to) {
            if(to.isEmpty()) {
                while(!from.isEmpty()) {
                    to.push(from.pop());
                }
            }
        }


    }
}
