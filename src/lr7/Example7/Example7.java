package lr7.Example7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Example7 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new FileReader("src/lr7/Example7/input.txt"));

        int lineCount = 0;
        while (reader.readLine() != null) {
            lineCount++;
        }
        reader.close();
        System.out.println("Количество строк в файле: " + lineCount);
    }
}
