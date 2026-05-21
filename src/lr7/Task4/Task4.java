package lr7.Task4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.stream.Stream;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя файла:");
        String fileName = scanner.nextLine();

        System.out.println("Введите слово для поиска:");
        String searchWord = scanner.nextLine();

        try (Stream<String> lines = Files.lines(Path.of(fileName))) {
            lines.filter(line -> line.contains(searchWord))
                    .forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
