import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class MonkeyBusiness {

    public static int n;
    public static int[] expression;
    public static int results = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());

        expression = new int[n];

        combination(0, 1);
        System.out.printf("Total Solutions: %d%n", results);
    }


    private static void combination(int index, int start) {
        if (index == expression.length) {
            print();
        } else {
            for (int i = start; i <= expression.length; i++) {
                expression[index] = i;
                combination(index + 1, i + 1);
                expression[index] = -i;
                combination(index + 1, i + 1);
            }
        }
    }

    private static void print() {
        int sum = Arrays.stream(expression)
                .sum();
        if (sum == 0) {
            results++;
            for (int i = 0; i < expression.length; i++) {
                if (expression[i] > 0) {
                    System.out.print("+" + expression[i] + " ");
                } else {
                    System.out.print(expression[i] + " ");
                }
            }
            System.out.println();
        }
    }
}
