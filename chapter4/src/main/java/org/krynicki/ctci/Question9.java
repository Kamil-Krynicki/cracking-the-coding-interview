package org.krynicki.ctci;

import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by kamil.krynicki on 03/05/2017.
 */
public class Question9 {
    static class BstSequences {
        public <T> Set<List<T>> bstSequences(TreeNode<T> root) {
            if (root == null)
                return Collections.emptySet();

            return bstSequences(
                    Sets.newHashSet(root),
                    Sets.<List<T>>newHashSet(new ArrayList<T>())
            );
        }

        private <T> Set<List<T>> bstSequences(Set<TreeNode<T>> front, Set<List<T>> current) {
            if (front.isEmpty()) {
                return current;
            }

            Set<List<T>> result = new HashSet<>();

            for (TreeNode<T> node : new HashSet<>(front)) {
                advance(front, node);

                Set<List<T>> newCurrent = deepClone(current);

                for (List<T> bst : newCurrent) {
                    bst.add(node.data);
                }

                result.addAll(bstSequences(front, newCurrent));

                retreat(front, node);
            }

            return result;
        }

        private <T> void retreat(Set<TreeNode<T>> front, TreeNode<T> node) {
            front.add(node);
            if (node.hasLeft()) front.remove(node.left());
            if (node.hasRight()) front.remove(node.right());
        }

        private <T> void advance(Set<TreeNode<T>> front, TreeNode<T> node) {
            front.remove(node);
            if (node.hasLeft()) front.add(node.left());
            if (node.hasRight()) front.add(node.right());
        }

        private <T> Set<List<T>> deepClone(Set<List<T>> current) {
            Set<List<T>> result = new HashSet<>();

            for (List<T> bst : current) {
                result.add(new ArrayList<T>(bst));
            }

            return result;
        }
    }
}
