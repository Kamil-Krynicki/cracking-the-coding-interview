package org.krynicki.ctci;

/**
 * Created by kamil.krynicki on 04/05/2017.
 */
public class Question10 {
    static class SubTreeChecker {
        public final <T> boolean isSubTree(TreeNode<T> tree, TreeNode<T> subtree) {
            if (isEmpty(subtree))
                return true;

            if (isEmpty(tree))
                return false;

            return matchTree(tree, subtree)
                    || isSubTree(tree.left(), subtree)
                    || isSubTree(tree.right(), subtree);
        }

        private <T> boolean matchTree(TreeNode<T> treeA, TreeNode<T> treeB) {
            return isEmpty(treeA) && isEmpty(treeB) || matchNode(treeA, treeB)
                    && matchTree(treeA.left(), treeB.left())
                    && matchTree(treeA.right(), treeB.right());

        }

        private <T> boolean matchNode(TreeNode<T> nodeA, TreeNode<T> nodeB) {
            return !isEmpty(nodeA) && !isEmpty(nodeB) && nodeA.data.equals(nodeB.data);
        }

        private <T> boolean isEmpty(TreeNode<T> node) {
            return node == null;
        }
    }
}
