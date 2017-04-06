package org.krynicki.ctci;

import static org.krynicki.ctci.TreeNode.node;

/**
 * Created by K on 2016-10-20.
 */
public class Question2 {
    static class ArrayToTree<Integer> {
        public TreeNode<Integer> toTree(Integer[] input) {
            return toTree(input, 0, input.length - 1);
        }

        private TreeNode<Integer> toTree(Integer[] input, int from, int to) {
            if (to < from) {
                return null;
            }

            int middle = (to + from) / 2;

            TreeNode<Integer> result = node(input[middle]);
            result.withLeft(toTree(input, from, middle - 1));
            result.withRight(toTree(input, middle + 1, to));

            return result;
        }
    }
}
