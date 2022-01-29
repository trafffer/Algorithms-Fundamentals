import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cinema {
    public static String[] seats;
    public static List<String> people;
    public static String[] combinations;
    public static boolean[] taken;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        people = Arrays.stream(bufferedReader.readLine().split(", "))
                .collect(Collectors.toList());
        seats = new String[people.size()];
        String line = bufferedReader.readLine();
        while (!line.equals("generate")) {
            String[] tokens = line.split(" - ");
            String name = tokens[0];
            int seat = Integer.parseInt(tokens[1]);
            seats[seat - 1] = name;
            people.remove(name);
            line = bufferedReader.readLine();
        }
        combinations = new String[people.size()];
        taken = new boolean[combinations.length];
        permute(0);
    }

    private static void permute(int i) {
        if (i == combinations.length) {
            print();
        } else {
            for (int f = 0; f < combinations.length; f++) {
                if (!taken[f]) {
                    taken[f] = true;
                    combinations[i] = people.get(f);
                    permute(i + 1);
                    taken[f] = false;
                }
            }
        }
    }

    private static void print() {
        int index = 0;
        String[] printed = new String[seats.length];
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] != null) {
                printed[i] = seats[i];
            } else {
                printed[i] = combinations[index++];
            }
        }
        System.out.println(String.join(" ", printed));
    }
}
