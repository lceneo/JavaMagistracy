package lr5.timus.task_2100;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.nextLine();

        int total = 2; // организаторы

        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            total++; // сам гость

            if (s.contains("+one")) {
                total++; // +1 человек
            }
        }

        if (total == 13) {
            total = 14;
        }

        System.out.println(total * 100);
    }
}