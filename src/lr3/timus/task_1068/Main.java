package lr3.timus.task_1068;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int result;
        if (N >= 1) {
            result = N * (N + 1) / 2;
        } else {
            result = (1 + N) * (2 - N) / 2;
        }

        System.out.println(result);

        scanner.close();
    }
}