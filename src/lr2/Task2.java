package lr2;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество строк:");
        int rows = scanner.nextInt();

        System.out.println("Введите количество столбцов:");
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];

        // Заполнение массива змейкой
        int value = 1;
        for (int i = 0; i < rows; i++) {
            if (i % 2 == 0) {
                // Чётная строка - слева направо
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = value++;
                }
            } else {
                // Нечётная строка - справа налево
                for (int j = cols - 1; j >= 0; j--) {
                    matrix[i][j] = value++;
                }
            }
        }

        // Вывод массива
        System.out.println("\nМассив змейкой:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
