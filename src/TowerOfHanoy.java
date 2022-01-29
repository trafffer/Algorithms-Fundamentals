import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.stream.Collectors;


public class TowerOfHanoy {
    public static StringBuilder sb = new StringBuilder();
    public static Deque<Integer> source = new ArrayDeque<>();
    public static Deque<Integer> spare = new ArrayDeque<>();
    public static Deque<Integer> destination = new ArrayDeque<>();
    public static int steps = 1;


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        for (int i = n; i >= 1; i--) {
            source.push(i);
        }

        solve(n, source, spare, destination);
        System.out.println(sb.toString());
        printRods();
    }

    private static void solve(int n, Deque<Integer> source, Deque<Integer> spare, Deque<Integer> destination) {
        if (n == 1) {
            destination.push(source.pop());
            sb.append("Step #")
                    .append(steps++)
                    .append(": Moved disc")
                    .append(System.lineSeparator());
            printRods();
        } else {
            solve(n - 1, source, destination, spare);
            solve(1, source, spare, destination);
            solve(n - 1, spare, source, destination);
        }
    }

    private static void printRods() {
        sb.append(String.format("Source: %s%nDestination: %s%nSpare: %s%n",
                formatRod(source), formatRod(destination), formatRod(spare)))
                .append(System.lineSeparator());
    }

    private static String formatRod(Deque<Integer> source) {
        return source.stream()
                .sorted(Comparator.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
