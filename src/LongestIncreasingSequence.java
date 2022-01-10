import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LongestIncreasingSequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] sequence = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] lenght = new int[sequence.length];
        int[] prev = new int[sequence.length];

        Arrays.fill(prev, -1);

        int maxLength = 0, bestIndex = 0;

        for (int i = 0; i < sequence.length; i++) {
            int current = sequence[i];
            int bestLength = 1;
            int index = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (sequence[j] < current && lenght[j] + 1 >= bestLength) {
                    bestLength = lenght[j] + 1;
                    index = j;
                }
            }
            prev[i] = index;
            lenght[i] = bestLength;
            if (bestLength > maxLength) {
                maxLength = bestLength;
                bestIndex = i;
            }
        }

        List<Integer> increasingSequence = new ArrayList<>();
        int index = bestIndex;

        while (index != -1) {
            increasingSequence.add(sequence[index]);
            index = prev[index];
        }
        for (int f = increasingSequence.size() - 1; f >= 0; f--) {
            System.out.print(increasingSequence.get(f) + " ");
        }
    }
}
