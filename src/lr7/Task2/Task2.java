package lr7.Task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя исходного файла:");
        String sourceFileName = scanner.nextLine();

        System.out.println("Введите имя файла для копии:");
        String targetFileName = scanner.nextLine();

        try {
            Files.copy(
                    Path.of(sourceFileName),
                    Path.of(targetFileName),
                    StandardCopyOption.REPLACE_EXISTING
            );
            System.out.println("Файл скопирован успешно!");
        } catch (IOException e) {
            System.out.println("Ошибка при копировании файла: " + e.getMessage());
        }
    }
}
