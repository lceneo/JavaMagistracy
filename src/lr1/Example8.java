package lr1;

import java.util.Scanner;

// Задача 3: Ввод дня недели, месяца и даты, вывод информации о дате
public class Example8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите название дня недели: ");
        String dayOfWeek = scanner.nextLine();

        System.out.print("Введите название месяца: ");
        String month = scanner.nextLine();

        System.out.print("Введите дату (номер дня в месяце): ");
        int date = scanner.nextInt();

        System.out.println("Сегодняшняя дата: " + dayOfWeek + ", " + date + " " + month);

        scanner.close();
    }
}

