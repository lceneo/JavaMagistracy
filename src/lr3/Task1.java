package lr3;

import java.util.Scanner;

public class Task1 {
    public static void toBinary(int n) {
        if (n > 1) {
            toBinary(n / 2);
        }
        System.out.print(n % 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите целое число: ");
        int number = scanner.nextInt();
        
        if (number == 0) {
            System.out.println("0");
        } else {
            if (number < 0) {
                System.out.print("-");
                number = -number;
            }
            toBinary(number);
            System.out.println();
        }
        
        scanner.close();
    }
}
