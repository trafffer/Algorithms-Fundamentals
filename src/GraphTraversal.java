import java.util.*;

public class GraphTraversal {

    public static int[][] graph;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nodes = Integer.parseInt(scanner.nextLine());
        int p = Integer.parseInt(scanner.nextLine());

        graph = new int[nodes + 1][];

        for (int i = 1; i <= nodes; i++) {
            String[] edges = scanner.nextLine().split(":");
            if (edges.length == 1) {
                graph[i] = new int[0];
            } else {
                graph[i] = Arrays.stream(edges[1].split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }
        }

        while (p-- > 0) {
            int[] relations = Arrays.stream(scanner.nextLine().split("-"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int source = relations[0];
            int destination = relations[1];
            System.out.printf("{%d, %d} -> ", source, destination);

            int[] previous = new int[graph.length];
            Arrays.fill(previous, -1);
            bfs(graph, source, destination, previous);

            List<Integer> path = new ArrayList<>();
            int parent = previous[destination];
            while (parent != -1) {
                path.add(parent);
                parent = previous[parent];
            }

            int size = path.isEmpty() ? -1 : path.size();

            System.out.println(size);
        }
    }

    private static void bfs(int[][] graph, int source, int destination, int[] prev) {
        Deque<Integer> queue = new ArrayDeque<>();

        queue.offer(source);
        boolean[] visited = new boolean[graph.length + 1];
        visited[source] = true;

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            visited[node] = true;

            if (node == destination) {
                return;
            }

            for (int i = 0; i < graph[node].length; i++) {
                int child = graph[node][i];
                if (!visited[child]) {
                    prev[child] = node;
                    visited[child] = true;
                    queue.offer(child);
                }
            }
        }
    }
}
