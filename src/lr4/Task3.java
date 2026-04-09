package lr4;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Задание 3. Сумма элементов типа byte одномерного массива, вводимого с клавиатуры.
 *
 * Возможные ошибки:
 * - InputMismatchException — ввод строки вместо числа / значение за пределами диапазона byte
 * - ArithmeticException — переполнение при вычислении суммы (результат за границами byte)
 */
public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte[] array = null;
        byte sum = 0;

        try {
            System.out.print("Введите количество элементов массива: ");
            int size = scanner.nextInt();

            array = new byte[size];

            System.out.println("Введите элементы массива (значения от " + Byte.MIN_VALUE + " до " + Byte.MAX_VALUE + "):");
            for (int i = 0; i < size; i++) {
                System.out.print("array[" + i + "] = ");
                array[i] = scanner.nextByte();
            }

            // Вычисляем сумму с проверкой на переполнение
            int tempSum = 0;
            for (byte value : array) {
                tempSum += value;
            }

            if (tempSum < Byte.MIN_VALUE || tempSum > Byte.MAX_VALUE) {
                throw new ArithmeticException(
                        "Переполнение типа byte: сумма = " + tempSum +
                                ", допустимый диапазон: [" + Byte.MIN_VALUE + ".." + Byte.MAX_VALUE + "]");
            }

            sum = (byte) tempSum;
            System.out.println("Сумма элементов: " + sum);

        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода: ожидалось число типа byte, но введены некорректные данные — " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Ошибка вычисления: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Непредвиденная ошибка: " + e.getMessage());
        } finally {
            System.out.println("Вычисление завершено.");
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
