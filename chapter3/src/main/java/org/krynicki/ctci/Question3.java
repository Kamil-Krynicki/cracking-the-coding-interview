package org.krynicki.ctci;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by K on 2016-10-04.
 */
public class Question3 {
    static class SetOfStacks<T> implements Stack<T> {
        private final int threshold;
        private List<SimpleStack<T>> stacks;
        private SimpleStack<T> lastStack;

        public SetOfStacks(int threshold) {
            this.threshold = threshold;
            this.stacks = new ArrayList<>();
        }

        public void push(T value) {
            if (lastStack.size() == threshold) {
                lastStack = new SimpleStack<>();
                stacks.add(lastStack);
            }

            lastStack.push(value);
        }

        public T pop() {
            T result = lastStack.pop();

            if (lastStack.isEmpty()) {
                stacks.remove(lastStack);
                lastStack = stacks.get(stacks.size() - 1);
            }

            return result;
        }

        @Override
        public T peek() {
            return lastStack.peek();
        }

        @Override
        public boolean isEmpty() {
            return lastStack.isEmpty();
        }

        public T popAt(int stack) {
            if (stack < stacks.size() && stack > 0) {
                T result = stacks.get(stack).pop();
                fixStacks(stack);
                return result;
            } else {
                throw new IllegalArgumentException("No such stack");
            }
        }

        private void fixStacks(int stack) {
            for (int i = stack; i < stacks.size() - 1; i++) {
                SimpleStack<T> thisStack = stacks.get(i);
                if (thisStack.size() != threshold) {
                    SimpleStack<T> nextStack = stacks.get(i + 1);
                    SimpleStack<T> tmp = new SimpleStack<>();

                    while (!nextStack.isEmpty()) {
                        tmp.push(nextStack.pop());
                    }

                    thisStack.push(tmp.pop());

                    while (!tmp.isEmpty()) {
                        nextStack.push(tmp.pop());
                    }
                }
            }
        }
    }

    private static class SimpleStack<T> implements Stack<T> {
        private int size = 0;
        private Node<T> root = null;

        public void push(T value) {
            root = new Node<T>(value, root);
            size++;
        }

        public T pop() {
            if (isEmpty()) {
                throw new IndexOutOfBoundsException("SimpleStack Empty");
            }
            T result = root.data;
            root = root.next;
            size--;
            return result;
        }

        @Override
        public T peek() {
            return root.data;
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

    }
}
