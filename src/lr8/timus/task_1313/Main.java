package lr8.timus.task_1313;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] image = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                image[i][j] = scanner.nextInt();
            }
        }

        StringBuilder result = new StringBuilder();
        for (int diagonal = 0; diagonal <= 2 * n - 2; diagonal++) {
            int row = Math.min(diagonal, n - 1);
            int lastRow = Math.max(0, diagonal - n + 1);

            while (row >= lastRow) {
                int column = diagonal - row;
                result.append(image[row][column]).append(' ');
                row--;
            }
        }

        System.out.println(result.toString().trim());
    }
}
