import java.util.*;

public class BFSExample {
    public static List<String> bfsShortestPath(Map<String, List<String>> graph, String start, String goal) {
        Queue<List<String>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        

        queue.add(Collections.singletonList(start));

        while (!queue.isEmpty()) {
            List<String> path = queue.poll(); 
            String node = path.get(path.size() - 1);
            
            if (visited.contains(node)) continue; 
            visited.add(node);

            if (node.equals(goal)) return path; 
            
           
            for (String neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    List<String> newPath = new ArrayList<>(path);
                    newPath.add(neighbor);
                    queue.add(newPath);
                }
            }
        }
        
        return null; 
    }

    public static void main(String[] args) {
       
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("A", Arrays.asList("B", "C"));
        graph.put("B", Arrays.asList("A", "D", "E"));
        graph.put("C", Arrays.asList("A", "F"));
        graph.put("D", Arrays.asList("B"));
        graph.put("E", Arrays.asList("B", "F"));
        graph.put("F", Arrays.asList("C", "E"));

      
        List<String> path = bfsShortestPath(graph, "A", "F");
        System.out.println("Shortest Path: " + path); 
    }
}
