import java.util.Scanner;

public class CombinationWithoutRepetition {
    public static int[] combination;
    public static int elements;
    public static int arraySize;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        elements = Integer.parseInt(scanner.nextLine());
        arraySize = Integer.parseInt(scanner.nextLine());
        combination = new int[arraySize];
        combinate(0, 1);
    }

    private static void combinate(int index, int start) {
        if (index == combination.length) {
            print();
        } else {
            for (int i = start; i < elements + 1; i++) {
                combination[index] = i;
                combinate(index + 1, i + 1);
            }
        }
    }

    private static void print() {
        System.out.println(combination[0] + " " + combination[1]);
    }
}
