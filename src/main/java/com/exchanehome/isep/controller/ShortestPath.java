package com.exchanehome.isep.controller;

import java.util.*;

import java.util.*;

public class ShortestPath {
    private Graph graph;

    public ShortestPath(Graph graph) {
        this.graph = graph;
    }

//find find the minimum distance path between two vertices
    public List<Long> findShortestPath(Long start, Long end) {
        Map<Long, Long> distances = new HashMap<>();
        Map<Long, Long> previous = new HashMap<>();
        Set<Long> visited = new HashSet<>();
        PriorityQueue<Long> queue = new PriorityQueue<>(Comparator.comparingLong(distances::get));

        // Initialize distances
        for (Long vertex : graph.getVertices()) {
            distances.put(vertex, Long.MAX_VALUE);
        }
        distances.put(start, 0L);
        queue.add(start);

        while (!queue.isEmpty()) {
            Long current = queue.poll();
            if (current.equals(end)) {
                break; // Found the shortest path to the destination
            }
            if (visited.contains(current)) {
                continue; // Skip if already visited
            }

            visited.add(current);
            List<Edge> edges = graph.getEdges(current);
            for (Edge edge : edges) {
                Long neighbor = edge.destination;
                Long weight = edge.weight;
                Long totalDistance = distances.get(current) + weight;
                if (totalDistance < distances.get(neighbor)) {
                    distances.put(neighbor, totalDistance);
                    previous.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        // Reconstruct the shortest path
        List<Long> shortestPath = new ArrayList<>();
        Long current = end;
        while (current != null) {
            shortestPath.add(0, current);
            current = previous.get(current);
        }

        return shortestPath;
    }
    //find the minimum distance  path between two vertices and total sites n
    public List<Long> findShortestPath(Long start, Long end, int totalSites) {
        Map<Long, Long> distances = new HashMap<>();
        Map<Long, Long> previous = new HashMap<>();
        Set<Long> visited = new HashSet<>();
        PriorityQueue<Long> queue = new PriorityQueue<>(Comparator.comparingLong(distances::get));

        // Initialize distances
        for (Long vertex : graph.getVertices()) {
            distances.put(vertex, Long.MAX_VALUE);
        }
        distances.put(start, 0L);
        queue.add(start);

        while (!queue.isEmpty()) {
            Long current = queue.poll();
            if (current.equals(end)) {
                break; // Found the shortest path to the destination
            }
            if (visited.contains(current)) {
                continue; // Skip if already visited
            }

            visited.add(current);
            List<Edge> edges = graph.getEdges(current);
            for (Edge edge : edges) {
                Long neighbor = edge.destination;
                Long weight = edge.weight;
                Long totalDistance = distances.get(current) + weight;
                if (totalDistance < distances.get(neighbor)) {
                    distances.put(neighbor, totalDistance);
                    previous.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        // Reconstruct the shortest path
        List<Long> shortestPath = new ArrayList<>();
        Long current = end;
        while (current != null) {
            shortestPath.add(0, current);
            current = previous.get(current);
        }

        // Add intermediate sites to complete the total number of sites
        int currentSites = shortestPath.size();
        while (currentSites < totalSites) {
            shortestPath.add(1, null);
            currentSites++;
        }

        return shortestPath;
    }

    //find the minimum distance path between two vertices while considering the minimum number of total sites
    public List<Long> findShortestPathMiniSite(Long start, Long end, int minimumTotalSites) {
        Map<Long, Long> distances = new HashMap<>();
        Map<Long, Long> previous = new HashMap<>();
        Set<Long> visited = new HashSet<>();
        PriorityQueue<Long> queue = new PriorityQueue<>(Comparator.comparingLong(distances::get));

        // Initialize distances
        for (Long vertex : graph.getVertices()) {
            distances.put(vertex, Long.MAX_VALUE);
        }
        distances.put(start, 0L);
        queue.add(start);

        while (!queue.isEmpty()) {
            Long current = queue.poll();
            if (current.equals(end)) {
                break; // Found the shortest path to the destination
            }
            if (visited.contains(current)) {
                continue; // Skip if already visited
            }

            visited.add(current);
            List<Edge> edges = graph.getEdges(current);
            for (Edge edge : edges) {
                Long neighbor = edge.destination;
                Long weight = edge.weight;
                Long totalDistance = distances.get(current) + weight;
                if (totalDistance < distances.get(neighbor)) {
                    distances.put(neighbor, totalDistance);
                    previous.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        // Reconstruct the shortest path
        List<Long> shortestPath = new ArrayList<>();
        Long current = end;
        while (current != null) {
            shortestPath.add(0, current);
            current = previous.get(current);
        }

        // Add intermediate sites to meet the minimum total sites requirement
        int currentSites = shortestPath.size() - 2; // Exclude start and end vertices
        while (currentSites < minimumTotalSites) {
            shortestPath.add(1, null);
            currentSites++;
        }

        return shortestPath;
    }
    //find the minimum path between two vertices in a graph
    public List<Long> findMinimumPath(Long start, Long end) {
        Map<Long, Long> previous = new HashMap<>();
        Queue<Long> queue = new LinkedList<>();
        Set<Long> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Long current = queue.poll();
            if (current.equals(end)) {
                break; // Found the end vertex
            }

            List<Edge> edges = graph.getEdges(current);
            for (Edge edge : edges) {
                Long neighbor = edge.destination;
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                    previous.put(neighbor, current);
                }
            }
        }

        // Reconstruct the minimum path
        List<Long> minimumPath = new ArrayList<>();
        Long current = end;
        while (current != null) {
            minimumPath.add(0, current);
            current = previous.get(current);
        }

        return minimumPath;
    }
    //find the minimum sites path between two vertices in a graph, you can use a modified version of Dijkstra's algorithm that considers the number of sites visited instead of the actual distance
    public List<Long> findMinimumSitesPath(Long start, Long end) {
        Map<Long, Integer> sitesVisited = new HashMap<>();
        Map<Long, Long> previous = new HashMap<>();
        Set<Long> visited = new HashSet<>();
        PriorityQueue<Long> queue = new PriorityQueue<>(Comparator.comparingInt(sitesVisited::get));

        // Initialize sitesVisited
        for (Long vertex : graph.getVertices()) {
            sitesVisited.put(vertex, Integer.MAX_VALUE);
        }
        sitesVisited.put(start, 0);
        queue.add(start);

        while (!queue.isEmpty()) {
            Long current = queue.poll();
            if (current.equals(end)) {
                break; // Found the minimum sites path to the destination
            }
            if (visited.contains(current)) {
                continue; // Skip if already visited
            }

            visited.add(current);
            List<Edge> edges = graph.getEdges(current);
            for (Edge edge : edges) {
                Long neighbor = edge.destination;
                Integer sites = sitesVisited.get(current) + 1;
                if (sites < sitesVisited.get(neighbor)) {
                    sitesVisited.put(neighbor, sites);
                    previous.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        // Reconstruct the minimum sites path
        List<Long> minimumSitesPath = new ArrayList<>();
        Long current = end;
        while (current != null) {
            minimumSitesPath.add(0, current);
            current = previous.get(current);
        }

        return minimumSitesPath;
    }
}

