package com.exchanehome.isep.controller;

import java.util.*;


class Edge {
    Long source;
    Long destination;
    Long weight;

    public Edge(Long source, Long destination, Long weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

class Graph {
    private Map<Long, List<Edge>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void addEdge(Long source, Long destination, Long weight) {
        Edge edge = new Edge(source, destination, weight);
        adjacencyList.computeIfAbsent(source, k -> new ArrayList<>()).add(edge);

        // Since it's an undirected graph, add the reverse edge as well
        Edge reverseEdge = new Edge(destination, source, weight);
        adjacencyList.computeIfAbsent(destination, k -> new ArrayList<>()).add(reverseEdge);
    }

    public List<Edge> getEdges(Long vertex) {
        return adjacencyList.getOrDefault(vertex, new ArrayList<>());
    }

    public Set<Long> getVertices() {
        return adjacencyList.keySet();
    }

}

