package org.krynicki.ctci;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by K on 2016-10-24.
 */
public class Question3 {
    static class LevelList {
        public <T> List<List<TreeNode<T>>> levels(TreeNode<T> root) {
            ArrayList<List<TreeNode<T>>> result = new ArrayList<>();
            levels(root, result, 0);
            return result;
        }

        private <T> void levels(TreeNode<T> root, List<List<TreeNode<T>>> result, int level) {
            if(root == null) {
                return;
            }

            if (result.size() <= level) {
                result.add(new LinkedList<TreeNode<T>>());
            }

            result.get(level).add(root);

            levels(root.left(), result, level + 1);
            levels(root.right(), result, level + 1);
        }
    }
}
