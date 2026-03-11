package lr2;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите текст для шифрования");
        String text = scanner.nextLine();

        System.out.println("Введите ключ");
        int shift = scanner.nextInt();
        scanner.nextLine(); // потребляем оставшийся символ новой строки

        // Шифрование
        String encrypted = encrypt(text, shift);
        System.out.println("Текст после преобразования: " + encrypted);

        // Спросить про обратное преобразование
        while (true) {
            System.out.println("Выполнить обратное преобразование? (y/n)");
            String answer = scanner.nextLine();

            if (answer.equals("y")) {
                String decrypted = decrypt(encrypted, shift);
                System.out.println("Расшифрованный текст: " + decrypted);
                break;
            } else if (answer.equals("n")) {
                System.out.println("До свидания!");
                break;
            } else {
                System.out.println("Введите корректный ответ");
            }
        }
    }

    // Шифрование
    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            result.append((char) (c + shift));
        }
        return result.toString();
    }

    // Расшифровка
    public static String decrypt(String text, int shift) {
        return encrypt(text, -shift);
    }
}
