package lr1;

import java.util.Scanner;

// Задача 9: Последовательность из четырех чисел
public class Example14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");
        int number = scanner.nextInt();

        int first = number - 1;
        int second = number;
        int third = number + 1;
        int fourth = (first + second + third) * (first + second + third);

        System.out.println("Первое число (на 1 меньше): " + first);
        System.out.println("Введенное число: " + second);
        System.out.println("Третье число (на 1 больше): " + third);
        System.out.println("Четвертое число (квадрат суммы первых трех): " + fourth);

        scanner.close();
    }
}

