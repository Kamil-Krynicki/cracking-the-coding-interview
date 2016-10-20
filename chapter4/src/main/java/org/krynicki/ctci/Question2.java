package org.krynicki.ctci;

/**
 * Created by K on 2016-10-20.
 */
public class Question2 {
    static class ArrayToTree<Integer> {
        public TreeNode<Integer> toTree(Integer[] input) {
            return toTree(input, 0, input.length);
        }

        private TreeNode<Integer> toTree(Integer[] input, int from, int to) {
            if (to <= from) {
                return null;
            }

            int middle = (to + from) / 2;

            TreeNode<Integer> result = new TreeNode<>(input[middle]);
            result.left = toTree(input, from, middle - 1);
            result.right = toTree(input, middle + 1, to);

            return result;
        }
    }
}
