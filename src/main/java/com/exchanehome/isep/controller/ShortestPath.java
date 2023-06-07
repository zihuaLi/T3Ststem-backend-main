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
}

