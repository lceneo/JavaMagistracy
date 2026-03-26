package lr3.timus.task_1005;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] weights = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
            sum += weights[i];
        }

        int halfSum = sum / 2;
        boolean[] dp = new boolean[halfSum + 1];
        dp[0] = true;

        for (int weight : weights) {
            for (int j = halfSum; j >= weight; j--) {
                dp[j] = dp[j] || dp[j - weight];
            }
        }

        int maxFirstPile = 0;
        for (int i = halfSum; i >= 0; i--) {
            if (dp[i]) {
                maxFirstPile = i;
                break;
            }
        }

        int secondPile = sum - maxFirstPile;
        System.out.println(Math.abs(secondPile - maxFirstPile));

        scanner.close();
    }
}