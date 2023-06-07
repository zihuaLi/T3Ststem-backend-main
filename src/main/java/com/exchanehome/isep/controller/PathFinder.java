package com.exchanehome.isep.controller;

import java.util.*;

class PathFinder {
    private Graph graph;
    private List<Long> visited;
    private List<Long> path;
    private List<Long> bestPath;

    public PathFinder(Graph graph) {
        this.graph = graph;
        visited = new ArrayList<>();
        path = new ArrayList<>();
        bestPath = new ArrayList<>();
    }
//find the Maximum sites between two sites
    public List<Long> findMaximumPath(Long start, Long end) {
        //dfs(start, end);
        List<Long> visited = new ArrayList<>();
        List<Long> path = new ArrayList<>();
        List<Long> bestPath = new ArrayList<>();

        dfs(start, end, visited, path, bestPath);

        return bestPath;
    }
    private void dfs(Long vertex, Long end, List<Long> visited, List<Long> path, List<Long> bestPath) {
        visited.add(vertex);
        path.add(vertex);

        if (vertex.equals(end)) {
            if (path.size() > bestPath.size()) {
                bestPath.clear();
                bestPath.addAll(path);
            }
        } else {
            List<Edge> edges = graph.getEdges(vertex);
            for (Edge edge : edges) {
                Long neighbor = edge.destination;
                if (!visited.contains(neighbor)) {
                    dfs(neighbor, end, visited, path, bestPath);
                }
            }
        }

        path.remove(vertex);
        visited.remove(vertex);
    }
/*
    private void dfs(Long vertex, Long end) {
        visited.add(vertex);
        path.add(vertex);

        if (vertex.equals(end)) {
            if (path.size() > bestPath.size()) {
                bestPath = new ArrayList<>(path);
            }
        } else {
            List<Edge> edges = graph.getEdges(vertex);
            for (Edge edge : edges) {
                Long neighbor = edge.destination;
                if (!visited.contains(neighbor)) {
                    dfs(neighbor, end);
                }
            }
        }

        path.remove(vertex);
        visited.remove(vertex);
    }
*/
}

