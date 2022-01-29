import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClusterBorder {
    public static int[] dp;


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] singleShipTime = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] pairTime = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        dp = new int[singleShipTime.length + 1];

        dp[1] = singleShipTime[0];

        for (int i = 2; i <= singleShipTime.length; i++) {
            dp[i] = Math.min(dp[i - 1] + singleShipTime[i - 1], dp[i - 2] + pairTime[i - 2]);
        }
        System.out.println("Optimal time: " + dp[singleShipTime.length]);

        List<String> sb = new ArrayList<>();
        for (int j = dp.length - 1; j > 0; j--) {
            int timeDiff = dp[j] - dp[j - 1];
            if (timeDiff == singleShipTime[j - 1]) {
                sb.add("Single " + j);
            } else {
                sb.add("Pair of " + (j - 1) + " and " + j);
                j--;
            }
        }
        for (int i = sb.size() - 1; i >= 0; i--) {
            String s = sb.get(i);
            System.out.println(s);
        }
    }
}

