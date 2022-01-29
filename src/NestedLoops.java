import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NestedLoops {
    public static int[] numbers;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());

        numbers = new int[n];
        permute(0);
    }

    private static void permute(int i) {
        if (i == n) {
            printArr();
        } else {
            for (int f = 1; f < n + 1; f++) {
                numbers[i] = f;
                permute(i + 1);
            }
        }
    }

    private static void printArr() {
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}
