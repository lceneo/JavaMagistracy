package lr2.timus.task_2001;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int a1 = scanner.nextInt();
        int b1 = scanner.nextInt();
        int a2 = scanner.nextInt();
        int b2 = scanner.nextInt();
        int a3 = scanner.nextInt();
        int b3 = scanner.nextInt();

        int first = a1 - a3;
        int second = b1 - b2;
        
        System.out.println(first + " " + second);
    }
}
