package lr7.Example8;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Example8 {
    public static void main(String[] args) throws IOException {
        String inputFileName = "src/lr7/Example8/input.txt";
        String outputFileName = "src/lr7/Example8/output.txt";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите данные для записи в исходный файл:");
        String data = scanner.nextLine();

        FileWriter inputWriter = new FileWriter(inputFileName);
        inputWriter.write(data);
        inputWriter.close();

        FileReader reader = new FileReader(inputFileName);
        FileWriter writer = new FileWriter(outputFileName);
        int c;
        while ((c = reader.read()) != -1) {
            writer.write(c);
        }
        reader.close();
        writer.close();
        System.out.println("Файл скопирован успешно!");
    }
}
