package lr8.timus.task_1319;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] table = new int[n][n];
        int number = 1;

        for (int diagonal = 0; diagonal <= 2 * n - 2; diagonal++) {
            int row;
            int column;
            if (diagonal < n) {
                row = 0;
                column = n - 1 - diagonal;
            } else {
                row = diagonal - n + 1;
                column = 0;
            }

            while (row < n && column < n) {
                table[row][column] = number++;
                row++;
                column++;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j > 0) {
                    result.append(' ');
                }
                result.append(table[i][j]);
            }
            result.append('\n');
        }

        System.out.print(result);
    }
}
