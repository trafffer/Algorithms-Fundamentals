import java.util.Scanner;

public class Fibbonachi {
    public static long[] db;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        db = new long[n + 1];
        db[1] = 1;
        db[2] = 1;

        for (int i = 3; i <= n; i++) {
            db[i] = db[i - 1] + db[i - 2];
        }
        System.out.println(db[n]);
    }
}
