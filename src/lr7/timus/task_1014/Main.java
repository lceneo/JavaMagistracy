package lr7.timus.task_1014;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (n == 0) {
            System.out.println(10);
            return;
        }

        if (n == 1) {
            System.out.println(1);
            return;
        }

        List<Integer> digits = new ArrayList<>();
        for (int digit = 9; digit >= 2; digit--) {
            while (n % digit == 0) {
                digits.add(digit);
                n /= digit;
            }
        }

        if (n != 1) {
            System.out.println(-1);
            return;
        }

        Collections.sort(digits);
        StringBuilder answer = new StringBuilder();
        for (int digit : digits) {
            answer.append(digit);
        }

        System.out.println(answer);
    }
}
