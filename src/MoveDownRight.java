import java.util.*;

public class MoveDownRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int[][] dp = new int[rows][cols];
        dp[0][0] = matrix[0][0];

        for (int col = 1; col < cols; col++) {
            dp[0][col] = dp[0][col - 1] + matrix[0][col];
        }

        for (int row = 1; row < rows; row++) {
            dp[row][0] = dp[row - 1][0] + matrix[row][0];
        }

        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                dp[row][col] = Math.max(dp[row][col - 1] + matrix[row][col]
                        , dp[row - 1][col] + matrix[row][col]);
            }
        }

        int endRow = rows - 1;
        int endCol = cols - 1;

        List<String> path = new ArrayList<>();
        path.add(formatOutput(endRow, endCol));

        while (endRow > 0 || endCol > 0) {
            int top = -1;
            int left = -1;
            if (endRow > 0) {
                top = dp[endRow - 1][endCol];
            }
            if (endCol > 0) {
                left = dp[endRow][endCol - 1];
            }
            if (top > left) {
                endRow--;
            } else {
                endCol--;
            }
            path.add(formatOutput(endRow, endCol));
        }

        Collections.reverse(path);
        System.out.println(String.join(" ", path));
    }

    private static String formatOutput(int endRow, int endCol) {
        return "[" + endRow + ", " + endCol + "]";
    }
}
