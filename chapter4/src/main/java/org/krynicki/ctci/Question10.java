package org.krynicki.ctci;

/**
 * Created by kamil.krynicki on 04/05/2017.
 */
public class Question10 {
    static class SubTreeChecker {
        public final <T> boolean isSubTree(TreeNode<T> rootA, TreeNode<T> rootB) {
            if (isEmpty(rootB))
                return true;

            if (isEmpty(rootA))
                return false;

            return matchTree(rootA, rootB)
                    || isSubTree(rootA.left(), rootB)
                    || isSubTree(rootA.right(), rootB);
        }

        private <T> boolean matchTree(TreeNode<T> rootA, TreeNode<T> rootB) {
            return isEmpty(rootA) && isEmpty(rootB) || matchNode(rootA, rootB)
                    && matchTree(rootA.left(), rootB.left())
                    && matchTree(rootA.right(), rootB.right());

        }

        private <T> boolean matchNode(TreeNode<T> nodeA, TreeNode<T> nodeB) {
            return !isEmpty(nodeA) && !isEmpty(nodeB) && nodeA.data.equals(nodeB.data);
        }

        private <T> boolean isEmpty(TreeNode<T> node) {
            return node == null;
        }
    }
}
