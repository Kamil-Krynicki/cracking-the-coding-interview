package org.krynicki.ctci;

/**
 * Created by K on 2016-10-03.
 */
public class Question2 {
    static class MinStack {
        MinNode root;

        int pop() {
            if (root == null) {
                throw new IndexOutOfBoundsException("empty");
            }

            MinNode tmp = root;
            root = root.next;

            return tmp.value;
        }

        void push(int value) {
            root = new MinNode(value, root);
        }

        int min() {
            if (root == null) {
                throw new IndexOutOfBoundsException("empty");
            }

            return root.minBelow;
        }
    }

    private static class MinNode {
        private final int minBelow;
        private final int value;
        private final MinNode next;

        public MinNode(int value, MinNode below) {
            this.value = value;
            if(below == null) {
                this.next = null;
                this.minBelow = value;
            }
            else {
                this.next = below;
                this.minBelow = below.minBelow > value ? value : below.minBelow;
            }
        }
    }
}
