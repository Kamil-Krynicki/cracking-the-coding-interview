package org.krynicki.ctci;

import com.google.common.base.MoreObjects;

import java.util.LinkedList;

/**
 * Created by kamil.krynicki on 28/04/2017.
 */
public class Question8 {
    public static class FirstCommonAncestor {
        public <T> TreeNode<T> fca(TreeNode<T> nodeA, TreeNode<T> nodeB) {
            if(nodeA == null || nodeB == null) return null;

            if(nodeA == nodeB) return nodeA;

            LinkedList<TreeNode<T>> rootToNodeA = parentSequence(nodeA);
            LinkedList<TreeNode<T>> rootToNodeB = parentSequence(nodeB);

            TreeNode<T> prv = null;
            TreeNode<T> headA, headB;

            while(!rootToNodeA.isEmpty() && !rootToNodeB.isEmpty()) {
                headA = rootToNodeA.pollFirst();
                headB = rootToNodeB.pollFirst();

                if (headA == headB)
                    prv = headA;
                else
                    return prv;
            }

            return prv;
        }

        // with parent pointers O(logn)
        private <T> LinkedList<TreeNode<T>> parentSequence(TreeNode<T> node) {
            LinkedList<TreeNode<T>> result = new LinkedList<>();

            TreeNode<T> current = node;

            while(current != null) {
                result.addFirst(current);
                current = current.parent();
            }

            return result;
        }

        //without parentPointers O(n)
        private <T> LinkedList<TreeNode<T>> parentSequence(TreeNode<T> node, TreeNode<T> root) {
            if(root == null) return null;

            LinkedList<TreeNode<T>> result = singleton(node);

            if(root == node) return result;

            LinkedList<TreeNode<T>> l = parentSequence(node, root.left());
            LinkedList<TreeNode<T>> r = parentSequence(node, root.right());

            result.addAll(MoreObjects.firstNonNull(l, r));

            return result;
        }

        private <T> LinkedList<TreeNode<T>> singleton(TreeNode<T> node) {
            LinkedList<TreeNode<T>> result = new LinkedList<>();
            result.add(node);
            return result;
        }
    }
}
