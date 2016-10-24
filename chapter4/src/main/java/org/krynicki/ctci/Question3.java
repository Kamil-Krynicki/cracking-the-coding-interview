package org.krynicki.ctci;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by K on 2016-10-24.
 */
public class Question3 {
    static class LevelList {
        public List<List<TreeNode<?>>> levels(TreeNode<?> root) {
            ArrayList<List<TreeNode<?>>> result = new ArrayList<>();
            levels(root, result, 0);
            return result;
        }

        private void levels(TreeNode<?> root, List<List<TreeNode<?>>> result, int level) {
            if (result.get(level) == null) {
                result.add(new LinkedList<TreeNode<?>>());
            }

            result.get(level).add(root);

            levels(root.left, result, level + 1);
            levels(root.right, result, level + 1);
        }
    }
}
