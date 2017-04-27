package org.krynicki.ctci;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.Deque;
import java.util.List;
import java.util.Set;

/**
 * Created by K on 24.04.2017.
 */
public class Question7 {
    public static class TopologicalSort<T> {
        private Set<T> done = Sets.newHashSet();
        private Set<T> visits = Sets.newHashSet();

        private Deque<T> order = Lists.newLinkedList();

        public TopologicalSort(DirectedGraph<T> graph) {
            solve(graph);
        }

        public List<T> getOrder() {
            return ImmutableList.copyOf(order);
        }

        private void solve(DirectedGraph<T> graph) {
            Preconditions.checkNotNull(graph);

            for(T node : graph.nodes()) {
                if(!explored(node)) {
                    explore(node, graph);
                }
            }
        }

        private void explore(T node, DirectedGraph<T> graph) {
            for(T neighbour : graph.neighbours(node)) {
                if(revisiting(neighbour)) {
                    throw new IllegalArgumentException("cycle");
                }

                if (!explored(neighbour)) {
                    visits.add(neighbour);
                    explore(neighbour, graph);
                    visits.remove(neighbour);
                }
            }

            done.add(node);
            order.addLast(node);
        }

        private boolean revisiting(T neighbour) {
            return visits.contains(neighbour);
        }

        private boolean explored(T neighbour) {
            return done.contains(neighbour);
        }
    }
}
