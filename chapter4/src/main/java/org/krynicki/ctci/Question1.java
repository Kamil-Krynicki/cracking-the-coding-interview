package org.krynicki.ctci;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by K on 2016-10-19.
 */
public class Question1 {
    static class PathFinder {
        boolean isPath(DirectedGraph<Integer> graph, Integer from, Integer to) {
            if (graph == null || from == null || to == null) {
                throw new NullPointerException();
            }


            if (!graph.nodes().contains(from)) {
                return false;
            }

            if (!graph.nodes().contains(to)) {
                return false;
            }

            if (from == to) {
                return true;
            }

            Queue<Integer> reachable = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();

            reachable.add(from);

            Integer toVisit;

            while (!reachable.isEmpty()) {
                if (reachable.contains(to)) {
                    return true;
                }

                toVisit = reachable.poll();

                visited.add(toVisit);

                reachable.addAll(graph.edgesFrom(toVisit));
                reachable.removeAll(visited);
            }
            return false;
        }
    }
}
