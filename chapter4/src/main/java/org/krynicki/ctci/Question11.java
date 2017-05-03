package org.krynicki.ctci;

import com.google.common.base.Preconditions;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by kamil.krynicki on 03/05/2017.
 */
public class Question11 {
    static class Randomizer {
        // I know the trick very well
        // without augmented "size" field it's O(n), with it it'd be O(logn)
        public <T> TreeNode<T> randomNode(TreeNode<T> root) {
            Preconditions.checkNotNull(root);

            Deque<TreeNode<T>> nodes = new LinkedList<>();
            nodes.add(root);

            TreeNode<T> current, result = null;
            int count = 0;

            while (!nodes.isEmpty()) {
                current = nodes.pop();

                if (lucky(++count)) {
                    result = current;
                }

                pushChildren(nodes, current);
            }

            return result;
        }

        private <T> void pushChildren(Deque<TreeNode<T>> nodes, TreeNode<T> current) {
            if (current.hasLeft()) nodes.push(current.left());
            if (current.hasRight()) nodes.push(current.right());
        }

        private boolean lucky(int count) {
            return Math.random() < (double) 1 / count;
        }
    }
}
