package org.krynicki.ctci;

/**
 * Created by K on 2016-10-13.
 */
public class Question5 {
    static class SortStack<T extends Comparable<T>> {
        public void sort(Stack<T> in) {
            if(in == null) {
                throw new NullPointerException("in is null");
            }

            Stack<T> helperStack = new LinkedListStack<>();

            if (in.isEmpty()) {
                return;
            }

            helperStack.push(in.pop());

            while (!in.isEmpty()) {
                if (in.peek().compareTo(helperStack.peek()) >= 0) {
                    helperStack.push(in.pop());
                } else {
                    T tmp = in.pop();
                    while (!helperStack.isEmpty() && tmp.compareTo(helperStack.peek()) < 0) {
                        in.push(helperStack.pop());
                    }
                    helperStack.push(tmp);
                }
            }

            while (!helperStack.isEmpty()) {
                in.push(helperStack.pop());
            }
        }
    }
}
