package org.krynicki.ctci;

import org.testng.annotations.Test;

public class Question7Test {

    @Test
    public void testSolve() throws Exception {
        Question7 test = new Question7();

        DirectedGraph<Integer> kamil = new DirectedGraph<>();

        kamil.addNode(4);
        kamil.addNode(3);
        kamil.addNode(2);
        kamil.addNode(1);

        kamil.addEdge(2, 1);
        kamil.addEdge(1, 3);
        kamil.addEdge(3, 4);

        test.solve(kamil);
    }
}