package lr7.Example9;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Example9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя:");
        String name = scanner.nextLine();
        System.out.println("Введите возраст:");
        int age = scanner.nextInt();

        Person person = new Person(name, age);

        try {
            FileOutputStream fileOut =
                    new FileOutputStream("src/lr7/Example9/person.json");
            ObjectOutputStream out =
                    new ObjectOutputStream(fileOut);
            out.writeObject(person);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in person.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
