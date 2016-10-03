package org.krynicki.ctci;

/**
 * Created by K on 2016-09-29.
 */

// this is the best possible solution: every operation in O(1) and no space is wasted
// PLUS - much smaller, more efficient and more elegant than the book
public class Question1 {
    static class ThreeStacks {
        private final int ARRAY_SIZE = 20;
        private final int NUMBER_OF_STACKS = 3;

        Node[] internalData = new Node[ARRAY_SIZE];
        Node[] stackHead = new Node[NUMBER_OF_STACKS];

        int nextFree = 0;

        void pushStack(Object data, int stackNumber) {
            if (!isValidStack(stackNumber)) throw new IllegalArgumentException("No such stack");
            if (!hasSpace()) throw new IndexOutOfBoundsException("No space");

            Node newNode = new Node(data);

            newNode.next = stackHead[stackNumber];
            stackHead[stackNumber] = newNode;

            internalData[nextFree++] = newNode;
        }

        Object popStack(int stackNumber) {
            if (!isValidStack(stackNumber)) throw new IllegalArgumentException("No such stack");
            if (isEmpty()) throw new IndexOutOfBoundsException("Empty");

            Object result = stackHead[stackNumber].data;
            Node nextHead = stackHead[stackNumber].next;

            nextFree--;

            stackHead[stackNumber].data = internalData[nextFree].data;
            stackHead[stackNumber].next = internalData[nextFree].next;

            internalData[nextFree] = null;

            stackHead[stackNumber] = nextHead;

            return result;
        }

        private boolean isEmpty() {
            return nextFree == 0;
        }

        private boolean hasSpace() {
            return nextFree < internalData.length;
        }

        private boolean isValidStack(int stackNumber) {
            return stackNumber < NUMBER_OF_STACKS && stackNumber >= 0;
        }
    }
}
