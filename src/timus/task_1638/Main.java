package timus.task_1638;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        List<Long> numbers = new ArrayList<>();

        while (scanner.hasNext()) {
            numbers.add(scanner.nextLong());
        }

        for (int i = numbers.size() - 1; i >= 0; i--) {
            double sqrtValue = Math.sqrt(numbers.get(i));
            System.out.printf("%.4f%n", sqrtValue);
        }

        scanner.close();
    }
}