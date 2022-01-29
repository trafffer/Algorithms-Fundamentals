import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TBC {
    public static char[][] matrix;
    public static int tunelsNumber;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int rows = Integer.parseInt(reader.readLine());
        int columns = Integer.parseInt(reader.readLine());

        matrix = new char[rows][columns];

        for (int i = 0; i < rows; i++) {
            matrix[i] = reader.readLine().toCharArray();
        }
        tunelsNumber = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 't') {
                    tunelsNumber++;
                    findTunnel(i, j);
                }
            }
        }
        System.out.println(tunelsNumber);
    }

    private static void findTunnel(int i, int j) {
        if (isOutBoinds(i, j) || isNotTraverce(i, j)) {
            return;
        }
        matrix[i][j] = 'V';
        findTunnel(i - 1, j);
        findTunnel(i - 1, j - 1);
        findTunnel(i, j - 1);
        findTunnel(i + 1, j - 1);
        findTunnel(i + 1, j);
        findTunnel(i + 1, j + 1);
        findTunnel(i, j + 1);
        findTunnel(i - 1, j + 1);
    }

    private static boolean isNotTraverce(int i, int j) {
        return matrix[i][j] == 'V' || matrix[i][j] == 'd';
    }

    private static boolean isOutBoinds(int i, int j) {
        return i < 0 || i >= matrix.length || j < 0 || j >= matrix[i].length;
    }
}
