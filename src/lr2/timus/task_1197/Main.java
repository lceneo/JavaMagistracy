package lr2.timus.task_1197;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        for (int i = 0; i < n; i++) {
            String pos = scanner.next();
            int col = pos.charAt(0) - 'a';
            int row = pos.charAt(1) - '1';
            
            int count = 0;
            int[][] moves = {
                {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
                {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
            };
            
            for (int[] move : moves) {
                int newRow = row + move[1];
                int newCol = col + move[0];
                if (newRow >= 0 && newRow < 8 && newCol >= 0 && newCol < 8) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
