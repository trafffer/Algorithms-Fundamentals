import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CombinationWithRepetition {
    public static int n;
    public static int m;
    public static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        m = Integer.parseInt(bufferedReader.readLine());

        numbers = new int[m];

        combinate(0, 1);
    }

    private static void combinate(int i, int start) {
        if (i == m) {
            printArr();
        } else {
            for (int f = start; f < n + 1; f++) {
                numbers[i] = f;
                combinate(i + 1, f);
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
