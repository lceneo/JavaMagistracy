package lr7.Task3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя файла:");
        String fileName = scanner.nextLine();

        try {
            long fileSize = Files.size(Path.of(fileName));
            System.out.println("Размер файла в байтах: " + fileSize);
        } catch (IOException e) {
            System.out.println("Ошибка при получении размера файла: " + e.getMessage());
        }
    }
}
