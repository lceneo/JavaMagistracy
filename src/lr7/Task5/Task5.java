package lr7.Task5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя файла:");
        String fileName = scanner.nextLine();

        System.out.println("Введите текст для записи:");
        String text = scanner.nextLine();

        try {
            Files.writeString(Path.of(fileName), text);
            System.out.println("Количество записанных символов: " + text.length());
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
}
