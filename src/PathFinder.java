import java.util.Arrays;
import java.util.Scanner;

public class PathFinder {
    public static int[][] graph;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nodes = Integer.parseInt(scanner.nextLine());
        graph = new int[nodes][nodes];

        for (int i = 0; i < nodes; i++) {
            String input = scanner.nextLine();
            if (input.length() > 1) {
                int[] ints = Arrays.stream(input.split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                for (int anInt : ints) {
                    graph[i][anInt] = 1;
                }
            } else if (input.length() == 1) {
                int column = Integer.parseInt(input);
                graph[i][column] = 1;
            }
        }

        int paths = Integer.parseInt(scanner.nextLine());
        boolean[] pathsExist = new boolean[paths];

        for (int i = 0; i < paths; i++) {
            int[] singlePath = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            pathsExist[i] = checkIfExist(singlePath);
        }

        for (boolean b : pathsExist) {
            if (b) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    private static boolean checkIfExist(int[] singlePath) {
        int[] pathcreator = new int[singlePath.length - 1];
        Arrays.fill(pathcreator, 0);
        for (int i = 0; i < singlePath.length - 1; i++) {
            if (graph[singlePath[i]][singlePath[i + 1]] == 1) {
                pathcreator[i] = 1;
            }
        }
        return Arrays.stream(pathcreator).sum() == singlePath.length - 1;
    }
}
