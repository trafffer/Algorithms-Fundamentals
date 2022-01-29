import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ReversedArray {
    public static String[] reversed;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] elements = bufferedReader.readLine().split("\\s+");

        printReversed(elements, elements.length - 1);
    }

    private static void printReversed(String[] elements, int i) {
        if (i < 0) {
            return;
        }
        System.out.print(elements[i] + " ");
        printReversed(elements, i - 1);
    }
}
