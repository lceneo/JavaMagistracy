package lr7.Example6;

import java.io.*;
import java.util.Scanner;

public class Example6 {
    public static void main(String[] args) {
        String outputFileName = "src/lr7/Example6/output.txt";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите данные для записи в файл:");
        String data = scanner.nextLine();

        try (PrintWriter printWriter =
                     new PrintWriter(outputFileName, "UTF-8")) {

            printWriter.println(data.toUpperCase());

            System.out.println("Данные записаны в файл: " + outputFileName);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении/записи файла: " + e.getMessage());
        }
    }
}
