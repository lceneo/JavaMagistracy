package lr1;

import java.util.Scanner;

// Задача 6: Ввод имени и года рождения, вывод имени и возраста
public class Example11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя: ");
        String name = scanner.nextLine();

        System.out.print("Введите год рождения: ");
        int birthYear = scanner.nextInt();

        int currentYear = 2026;
        int age = currentYear - birthYear;

        System.out.println("Имя: " + name + ", Возраст: " + age);

        scanner.close();
    }
}

