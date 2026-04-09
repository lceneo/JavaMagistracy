package lr4;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Задание 1. Среднее значение среди положительных элементов одномерного массива (int).
 *
 * Возможные ошибки:
 * - InputMismatchException — ввод строки вместо числа / несоответствие числового типа
 * - ArithmeticException — положительные элементы отсутствуют (деление на ноль)
 */
public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = null;
        double average = 0.0;

        try {
            System.out.print("Введите количество элементов массива: ");
            int size = scanner.nextInt();

            array = new int[size];

            System.out.println("Введите элементы массива:");
            for (int i = 0; i < size; i++) {
                System.out.print("array[" + i + "] = ");
                array[i] = scanner.nextInt();
            }

            int sum = 0;
            int count = 0;

            for (int value : array) {
                if (value > 0) {
                    sum += value;
                    count++;
                }
            }

            if (count == 0) {
                throw new ArithmeticException("Положительные элементы отсутствуют — невозможно вычислить среднее");
            }

            average = (double) sum / count;
            System.out.println("Сумма положительных элементов: " + sum);
            System.out.println("Количество положительных элементов: " + count);
            System.out.println("Среднее значение: " + average);

        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода: ожидалось целое число, но введены некорректные данные — " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Ошибка вычисления: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Непредвиденная ошибка: " + e.getMessage());
        } finally {
            System.out.println("Ввод данных завершён.");
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
