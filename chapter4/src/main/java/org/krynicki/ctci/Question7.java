package org.krynicki.ctci;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.Deque;
import java.util.Set;

/**
 * Created by K on 24.04.2017.
 */
public class Question7 {
    // basic topological sort

    Set<Integer> done = Sets.newHashSet();
    Deque<Integer> order = Lists.newLinkedList();

    public void solve(DirectedGraph<Integer> graph) {
        for(Integer node : graph.nodes()) {
            if(!done.contains(node)) {
                Deque<Integer> visiting = Lists.newLinkedList();
                inDepth(node, graph, visiting);
            }
        }

        System.out.println(order);
    }

    public void inDepth(Integer node, DirectedGraph<Integer> graph, Deque<Integer> visiting) {
        for(Integer neighbour : graph.neighbours(node)) {
            if(visiting.contains(neighbour)) {
                throw new IllegalArgumentException("cycle");
            }

            if (!done.contains(neighbour)) {
                visiting.add(neighbour);
                inDepth(neighbour, graph, visiting);
                visiting.remove(neighbour);
            }
        }

        done.add(node);
        order.push(node);
    }
}
