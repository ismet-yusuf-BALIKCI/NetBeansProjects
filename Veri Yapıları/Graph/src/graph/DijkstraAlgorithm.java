package graph;
import java.util.*;

public class DijkstraAlgorithm {
    private static final int INFINITY = Integer.MAX_VALUE;

    public static void main(String[] args) {
        // Graf oluştur
        Map<Integer, Map<Integer, Integer>> graph = createRandomGraph();

        // 1. düğümden başlayarak en kısa yolu bul
        Map<Integer, Integer> shortestPath = findShortestPath(graph, 1, 5);

        // Sonucu yazdır
        System.out.println("En kısa yol: " + shortestPath.keySet());
        System.out.println("Toplam maliyet: " + shortestPath.get(5));
    }

    private static Map<Integer, Map<Integer, Integer>> createRandomGraph() {
        Random random = new Random();
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();

        // Düğümler arasında rastgele ağırlıklarla bağlantıları oluştur
        for (int i = 1; i <= 4; i++) {
            Map<Integer, Integer> neighbors = new HashMap<>();
            for (int j = i + 1; j <= 5; j++) {
                int weight = random.nextInt(10) + 1; // Rastgele ağırlık (1-10 arası)
                neighbors.put(j, weight);
            }
            graph.put(i, neighbors);
        }

        return graph;
    }

    private static Map<Integer, Integer> findShortestPath(Map<Integer, Map<Integer, Integer>> graph, int start, int end) {
        Map<Integer, Integer> distance = new HashMap<>();
        Map<Integer, Integer> previous = new HashMap<>();
        Set<Integer> unvisited = new HashSet<>();

        // Başlangıç düğümüne mesafe 0, diğerleri için sonsuz olarak ayarla
        for (int vertex : graph.keySet()) {
            distance.put(vertex, vertex == start ? 0 : INFINITY);
            unvisited.add(vertex);
        }

        while (!unvisited.isEmpty()) {
            int current = getMinDistanceVertex(unvisited, distance);
            unvisited.remove(current);

            if (graph.containsKey(current)) {
                for (int neighbor : graph.get(current).keySet()) {
                    int alt = distance.get(current) + graph.get(current).get(neighbor);
                    if (alt < distance.get(neighbor)) {
                        distance.put(neighbor, alt);
                        previous.put(neighbor, current);
                    }
                }
            }
        }

        // En kısa yolu oluştur
        Map<Integer, Integer> shortestPath = new LinkedHashMap<>();
        int current = end;
        while (previous.containsKey(current)) {
            shortestPath.put(current, distance.get(current));
            current = previous.get(current);
        }
        shortestPath.put(start, 0);

        return shortestPath;
    }

    private static int getMinDistanceVertex(Set<Integer> unvisited, Map<Integer, Integer> distance) {
        int minVertex = -1;
        int minDistance = INFINITY;
        for (int vertex : unvisited) {
            if (distance.get(vertex) < minDistance) {
                minVertex = vertex;
                minDistance = distance.get(vertex);
            }
        }
        return minVertex;
    }
}
