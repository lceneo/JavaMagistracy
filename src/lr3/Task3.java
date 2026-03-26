package lr3;

import java.util.HashMap;
import java.util.Map;

public class Task3 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");

        System.out.println("Строки с ключом > 5:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() > 5) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        }

        System.out.println("\nСтроки с ключом = 0:");
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() == 0) {
                if (result.length() > 0) {
                    result.append(", ");
                }
                result.append(entry.getValue());
            }
        }
        System.out.println(result);

        System.out.println("\nПроизведение ключей, где длина строки > 5:");
        long product = 1;
        boolean found = false;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().length() > 5) {
                product *= entry.getKey();
                found = true;
                System.out.println(entry.getKey());
            }
        }
        if (found) {
            System.out.println("Произведение: " + product);
        } else {
            System.out.println("Нет строк с длиной > 5");
        }
    }
}
