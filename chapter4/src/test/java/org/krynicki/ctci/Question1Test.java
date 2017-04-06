package org.krynicki.ctci;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by K on 2016-10-20.
 */
public class Question1Test {
    private Question1.PathFinder finder = new Question1.PathFinder();

    @Test(expectedExceptions = NullPointerException.class)
    public void shouldThrowOnNullGraph() throws Exception {
        finder.isPath(null, 1, 1);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void shouldThrowOnNullNodes() throws Exception {
        finder.isPath(new DirectedGraph<Integer>(), null, null);
    }

    @Test
    public void shouldReturnFalseOnNotExistingNodes() throws Exception {
        DirectedGraph<Integer> graph = new DirectedGraph<>();

        graph.addNode(1);
        graph.addNode(2);
        graph.addEdge(1, 2);

        Assert.assertFalse(finder.isPath(graph, 2, 3));
        Assert.assertFalse(finder.isPath(graph, 1, 3));
        Assert.assertFalse(finder.isPath(graph, 3, 1));
        Assert.assertFalse(finder.isPath(graph, 3, 3));
    }

    @Test
    public void shouldFindPath() throws Exception {
        DirectedGraph<Integer> graph = new DirectedGraph<>();

        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);
        graph.addNode(5);
        graph.addNode(6);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 1);
        graph.addEdge(3, 2);
        graph.addEdge(4, 5);


        Assert.assertFalse(finder.isPath(graph, 2, 6));
        Assert.assertFalse(finder.isPath(graph, 5, 3));
        Assert.assertFalse(finder.isPath(graph, 5, 1));
        Assert.assertTrue(finder.isPath(graph, 1, 3));
        Assert.assertTrue(finder.isPath(graph, 2, 5));
        Assert.assertTrue(finder.isPath(graph, 3, 3));
        Assert.assertFalse(finder.isPath(graph, 4, 1));
    }
}
