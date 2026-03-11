package lr2;

import java.util.Random;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Введите размер массива:");
        int size = scanner.nextInt();

        int[] nums = new int[size];

        // Заполнение массива случайными числами
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(100); // числа от 0 до 99
        }

        // Вывод массива
        System.out.println("Массив:");
        for (int i = 0; i < nums.length; i++) {
            System.out.println("Элемент [" + i + "] = " + nums[i]);
        }

        // Поиск минимального значения
        int minValue = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < minValue) {
                minValue = nums[i];
            }
        }

        // Поиск всех индексов с минимальным значением
        System.out.println("\nМинимальное значение: " + minValue);
        System.out.print("Индексы элементов с минимальным значением: ");
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == minValue) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
