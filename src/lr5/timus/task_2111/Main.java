package lr5.timus.task_2111;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        long sum = 0;
        long sumSquares = 0;

        for (int i = 0; i < n; i++) {
            long x = in.nextLong();
            sum += x;
            sumSquares += x * x;
        }

        long result = sum * sum;

        System.out.println(result);
    }
}