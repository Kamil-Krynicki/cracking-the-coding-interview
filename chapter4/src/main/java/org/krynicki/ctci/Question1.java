package org.krynicki.ctci;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by K on 2016-10-19.
 */
public class Question1 {
    static class PathFinder {
        <T> boolean isPath(DirectedGraph<T> graph, T from, T to) {
            checkNotNull(graph);
            checkNotNull(from);
            checkNotNull(to);

            if (!graph.nodes().contains(from) || !graph.nodes().contains(to)) {
                return false;
            }

            if (from.equals(to)) {
                return true;
            }

            Queue<T> reachable = new LinkedList<>();
            Set<T> visited = new HashSet<>();

            reachable.add(from);

            T visiting;

            while (!reachable.isEmpty()) {
                if (reachable.contains(to)) {
                    return true;
                }

                visiting = reachable.poll();

                for(T neighbour : graph.neighbours(visiting)) {
                    if(!visited.contains(neighbour)) {
                        reachable.add(neighbour);
                    }
                }

                visited.add(visiting);
            }

            return false;
        }
    }
}
