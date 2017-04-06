package org.krynicki.ctci;

import java.util.*;

/**
 * Created by K on 2016-10-19.
 */
public class DirectedGraph<T> {
    private final Set<T> nodes;
    private final Map<T, Set<T>> edges;

    public DirectedGraph() {
        this.nodes = new HashSet<>();
        this.edges = new HashMap<>();
    }

    public void addNode(T node) {
        if(!hasNode(node)) {
            nodes.add(node);
            edges.put(node, new HashSet<T>());
        }
    }

    public void addEdge(T from, T to) {
        if (hasNode(from) && hasNode(to)) {
            edges.get(from).add(to);
        }
    }

    public Set<T> nodes() {
        return Collections.unmodifiableSet(nodes);
    }

    public Set<T> neighbours(T node) {
        return hasNode(node) ?  edges.get(node) : Collections.<T>emptySet();
    }

    public boolean hasNode(T node) {
        return nodes.contains(node);
    }
}
