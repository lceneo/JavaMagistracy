package lr1;

import java.util.Scanner;

// Задача 7: По возрасту определяется год рождения
public class Example12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ваш возраст: ");
        int age = scanner.nextInt();

        int currentYear = 2026;
        int birthYear = currentYear - age;

        System.out.println("Ваш год рождения: " + birthYear);

        scanner.close();
    }
}

