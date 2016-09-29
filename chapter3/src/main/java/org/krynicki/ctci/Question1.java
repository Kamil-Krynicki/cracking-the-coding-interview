package org.krynicki.ctci;

/**
 * Created by K on 2016-09-29.
 */

// this is the best possible solution: every operation in O(1) and no space is wasted
// PLUS - much smaller, more efficient and more elegant than the book
public class Question1 {
    static class ThreeStacks {
        private static final int ARRAY_SIZE = 20;
        private final int NUMBER_OF_STACKS = 3;

        Node[] internalData = new Node[ARRAY_SIZE];
        Node[] stackHead = new Node[NUMBER_OF_STACKS];

        int nextFree = 0;

        void pushStack(Object data, int stackNumber) {
            if (!hasSpace()) throw new IndexOutOfBoundsException("No space");
            if (!isValidStack(stackNumber)) throw new IllegalArgumentException("No such stack");

            Node newNode = new Node(data);

            newNode.next = stackHead[stackNumber];
            stackHead[stackNumber] = newNode;

            internalData[nextFree++] = newNode;
        }

        Object popStack(int stackNumber) {
            if (!isValidStack(stackNumber)) throw new IllegalArgumentException("No such stack");

            if (nextFree == 0) return null;

            Object result = stackHead[stackNumber].data;
            Node nextHead = stackHead[stackNumber].next;

            nextFree--;

            stackHead[stackNumber].data = internalData[nextFree].data;
            stackHead[stackNumber].next = internalData[nextFree].next;

            internalData[nextFree] = null;

            stackHead[stackNumber] = nextHead;

            return result;
        }

        private boolean hasSpace() {
            return internalData.length > nextFree;
        }

        private boolean isValidStack(int stackNumber) {
            return stackNumber <= 2 && stackNumber >= 0;
        }
    }
}



