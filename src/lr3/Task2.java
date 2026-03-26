package lr3;

import java.util.Scanner;

public class Task2 {
    public static void inputArray(int[] arr, int index, Scanner scanner) {
        if (index >= arr.length) {
            return;
        }
        System.out.print("Введите элемент [" + index + "]: ");
        arr[index] = scanner.nextInt();
        inputArray(arr, index + 1, scanner);
    }

    public static void outputArray(int[] arr, int index) {
        if (index >= arr.length) {
            return;
        }
        System.out.print(arr[index] + " ");
        outputArray(arr, index + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();
        
        int[] array = new int[size];
        
        System.out.println("Ввод элементов массива:");
        inputArray(array, 0, scanner);
        
        System.out.println("\nЭлементы массива:");
        outputArray(array, 0);
        System.out.println();
        
        scanner.close();
    }
}
