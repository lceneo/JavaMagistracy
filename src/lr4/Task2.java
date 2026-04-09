package lr4;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Задание 2. Вывод столбца матрицы по номеру, заданному с клавиатуры.
 *
 * Возможные ошибки:
 * - InputMismatchException — ввод строки вместо числа
 * - ArrayIndexOutOfBoundsException — нет столбца с таким номером
 */
public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        try {
            System.out.println("Матрица:");
            for (int[] row : matrix) {
                for (int value : row) {
                    System.out.print(value + "\t");
                }
                System.out.println();
            }
            System.out.println("Количество столбцов: " + matrix[0].length);

            System.out.print("Введите номер столбца (0.." + (matrix[0].length - 1) + "): ");
            int columnNumber = scanner.nextInt();

            if (columnNumber < 0 || columnNumber >= matrix[0].length) {
                throw new ArrayIndexOutOfBoundsException(
                        "Столбца с номером " + columnNumber + " не существует. Доступные столбцы: 0.." + (matrix[0].length - 1));
            }

            System.out.println("Столбец №" + columnNumber + ":");
            for (int i = 0; i < matrix.length; i++) {
                System.out.println("  строка " + i + ": " + matrix[i][columnNumber]);
            }

        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода: ожидалось целое число, но введены некорректные данные — " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка индекса: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Непредвиденная ошибка: " + e.getMessage());
        } finally {
            System.out.println("Программа завершила работу.");
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
