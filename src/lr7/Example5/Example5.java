package lr7.Example5;

import java.io.*;
import java.util.Scanner;

public class Example5 {
    public static void main(String[] args) {
        String outputFileName = "src/lr7/Example5/output.txt";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите данные для записи в файл:");
        String data = scanner.nextLine();

        try (OutputStream outputStream =
                     new FileOutputStream(outputFileName);
             OutputStreamWriter outputStreamWriter =
                     new OutputStreamWriter(outputStream, "UTF-8");
             BufferedWriter bufferedWriter =
                     new BufferedWriter(outputStreamWriter)) {

            bufferedWriter.write(data.toUpperCase());
            bufferedWriter.newLine();

            System.out.println("Данные записаны в файл: " + outputFileName);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении/записи файла: " + e.getMessage());
        }
    }
}
