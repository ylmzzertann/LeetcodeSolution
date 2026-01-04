import java.util.*;

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        // Edge case: If source is already the target, no buses needed.
        if (source == target) return 0;

        // 1. Build the graph (Stop -> List of Buses)
        // Key: Stop ID, Value: List of Route Indices that visit this stop
        HashMap<Integer, List<Integer>> stopToRoutes = new HashMap<>();
        
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                stopToRoutes.computeIfAbsent(stop, k -> new ArrayList<>()).add(i);
            }
        }

        // 2. Initialize BFS
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visitedRoutes = new HashSet<>(); // To avoid riding the same bus twice
        HashSet<Integer> visitedStops = new HashSet<>();  // To avoid processing the same stop twice

        q.offer(source);
        visitedStops.add(source);
        
        int busesTaken = 0;

        // 3. Process the Queue
        while (!q.isEmpty()) {
            int size = q.size();
            busesTaken++; // We are taking a new bus (or transferring) for this level

            for (int i = 0; i < size; i++) {
                int currentStop = q.poll();

                // Get all buses passing through the current stop
                List<Integer> buses = stopToRoutes.get(currentStop);
                if (buses == null) continue; // No buses go through this stop

                for (int busId : buses) {
                    if (visitedRoutes.contains(busId)) continue; // Already took this bus
                    
                    visitedRoutes.add(busId); // Mark bus as taken

                    // Check all stops this bus goes to
                    for (int nextStop : routes[busId]) {
                        if (nextStop == target) {
                            return busesTaken; // Found the target!
                        }

                        if (!visitedStops.contains(nextStop)) {
                            visitedStops.add(nextStop);
                            q.offer(nextStop);
                        }
                    }
                }
            }
        }

        return -1; // Target is unreachable
    }
}