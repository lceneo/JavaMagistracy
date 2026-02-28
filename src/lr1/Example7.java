package lr1;
import java.util.Scanner;

// Задача 2: Ввод имени и возраста, вывод информации
public class Example7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя: ");
        String name = scanner.nextLine();

        System.out.print("Введите возраст: ");
        int age = scanner.nextInt();

        System.out.println("Имя: " + name + ", Возраст: " + age);

        scanner.close();
    }
}

