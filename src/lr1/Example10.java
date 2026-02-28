package lr1;

import java.util.Scanner;

// Задача 5: По году рождения определяется возраст пользователя
public class Example10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ваш год рождения: ");
        int birthYear = scanner.nextInt();

        int currentYear = 2026;
        int age = currentYear - birthYear;

        System.out.println("Ваш возраст: " + age);

        scanner.close();
    }
}

