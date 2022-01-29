import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Socks {
    public static int[] leftSocks;
    public static int[] rightSocks;
    public static List<Integer> lenght;
    public static int index;
    public static List<Integer> current;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        leftSocks = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        rightSocks = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        index = 0;
        lenght = new ArrayList<>();
        current = new ArrayList<>();
        checkSocks(0, 0);
        int maxLength = lenght.stream().max(Comparator.naturalOrder()).get();
        System.out.println(maxLength);
    }

    private static void checkSocks(int start, int point) {
        if (start == rightSocks.length) {
            print();
            current.clear();
            if (lenght.size() < rightSocks.length) {
                checkSocks(lenght.size(), 0);
            }
        } else {
            for (int i = point; i < leftSocks.length; i++) {
                if (rightSocks[start] == leftSocks[i]) {
                    current.add(rightSocks[start]);
                    index = i;
                    checkSocks(start + 1, i + 1);
                    return;
                }
            }
            checkSocks(start + 1, index);
        }
    }

    private static void print() {
        lenght.add(current.size());
    }
}
