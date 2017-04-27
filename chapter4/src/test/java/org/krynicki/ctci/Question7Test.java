package org.krynicki.ctci;

import com.google.common.collect.Lists;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.krynicki.ctci.Question7.TopologicalSort;

public class Question7Test {

    @Test(expectedExceptions = NullPointerException.class)
    public void shouldHandleNull() throws Exception {
        new TopologicalSort<>(null).getOrder();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void shouldDetectCycle() throws Exception {

        DirectedGraph<Integer> graph = new DirectedGraph<>();

        graph.addNode(4);
        graph.addNode(3);
        graph.addNode(2);
        graph.addNode(1);

        graph.addEdge(2, 1);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);

        new TopologicalSort<>(graph).getOrder();
    }

    @Test
    public void shouldSolveCycle() throws Exception {
        DirectedGraph<Integer> graph = new DirectedGraph<>();

        graph.addNode(4);
        graph.addNode(3);
        graph.addNode(2);
        graph.addNode(1);

        graph.addEdge(2, 1);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);

        Assert.assertEquals(new TopologicalSort<>(graph).getOrder(), Lists.newArrayList(4, 3, 1, 2));
    }
}