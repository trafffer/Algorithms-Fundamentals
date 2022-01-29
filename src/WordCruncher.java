import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class WordCruncher {

    public static List<String> input;
    public static List<String> spare = new ArrayList<>();
    public static String target;

    public static Set<String> out = new TreeSet<>();
    public static Map<Integer, List<String>> table = new HashMap<>();
    public static Map<String, Integer> occurrences = new HashMap<>();


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        input = Arrays.stream(bufferedReader.readLine().split(", "))
                .collect(Collectors.toList());
        target = bufferedReader.readLine();

        input.removeIf(next -> !target.contains(next));

        for (String s : input) {
            occurrences.putIfAbsent(s, 0);
            occurrences.put(s, occurrences.get(s) + 1);
            int index = target.indexOf(s);
            while (index != -1) {
                table.putIfAbsent(index, new ArrayList<>());
                table.get(index).add(s);
                index = target.indexOf(s, index + 1);
            }
        }
        permute(0);
        for (String s : out) {
            System.out.println(s);
        }

    }

    private static void permute(int index) {
        if (index == target.length()) {
            print();
        } else if (table.containsKey(index)) {
            List<String> strings = table.get(index);
            for (String string : strings) {
                if (occurrences.get(string) > 0) {
                    occurrences.put(string, occurrences.get(string) - 1);
                    spare.add(string);
                    permute(index + string.length());
                    spare.remove(spare.size() - 1);
                    occurrences.put(string, occurrences.get(string) + 1);
                }
            }
        }
    }

    private static void print() {
        String actual = String.join("", spare);
        if (actual.contains(target)) {
            out.add(String.join(" ", spare));
        }
    }
}
