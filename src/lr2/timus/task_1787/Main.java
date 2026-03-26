package lr2.timus.task_1787;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        
        int queue = 0;
        for (int i = 0; i < n; i++) {
            int arrived = scanner.nextInt();
            queue += arrived;
            queue = Math.max(0, queue - k);
        }
        
        System.out.println(queue);
    }
}
