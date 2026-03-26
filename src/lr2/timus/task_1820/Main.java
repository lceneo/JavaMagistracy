package lr2.timus.task_1820;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        
        int totalSides = n * 2;
        int minutes = (totalSides + k - 1) / k;
        
        System.out.println(minutes);
    }
}
