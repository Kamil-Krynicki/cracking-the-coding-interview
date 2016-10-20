package org.krynicki.ctci;

import java.util.*;

/**
 * Created by K on 2016-10-19.
 */
public class DirectedGraph<T> {
    Set<T> nodes;
    Map<T, List<T>> edges;

    public DirectedGraph() {
        this.nodes = new HashSet<>();
        this.edges = new HashMap<>();
    }

    public void add(T node) {
        if(!nodes.contains(node)) {
            nodes.add(node);
            edges.put(node, new LinkedList<T>());
        }
    }

    public void addEdge(T from, T to) {
        if(!nodes.contains(from)) {
            return;
        }

        if(!nodes.contains(to)) {
            return;
        }

        edges.get(from).add(to);
    }

    public boolean hasNode(T node) {
        return nodes.contains(node);
    }

    public Collection<T> nodes() {
        return nodes;
    }

    public Collection<T> edgesFrom(T node) {
        if(!nodes.contains(node)) {
            return null;
        }

        return edges.get(node);
    }
}
