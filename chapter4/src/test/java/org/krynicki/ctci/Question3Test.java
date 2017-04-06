package org.krynicki.ctci;

import org.testng.annotations.Test;

import static org.krynicki.ctci.TreeNode.node;

/**
 * Created by K on 06.04.2017.
 */
public class Question3Test {

    @Test
    public void shouldWork() {
        TreeNode<Integer> root = node(5)
                .withLeft(node(3))
                .withRight(node(4).withLeft(node(7)));

        System.out.print(new Question3.LevelList().levels(root));
    }

}