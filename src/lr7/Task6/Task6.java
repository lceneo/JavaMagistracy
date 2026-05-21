package lr7.Task6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "src/lr7/Task6/person.bin";

        System.out.println("Введите имя:");
        String name = scanner.nextLine();

        System.out.println("Введите возраст:");
        int age = scanner.nextInt();

        System.out.println("Введите средний балл:");
        double averageGrade = scanner.nextDouble();

        Person person = new Person(name, age, averageGrade);

        try (ObjectOutputStream outputStream =
                     new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(person);
            System.out.println("Объект записан в файл: " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка при записи объекта: " + e.getMessage());
            return;
        }

        try (ObjectInputStream inputStream =
                     new ObjectInputStream(new FileInputStream(fileName))) {
            Person restoredPerson = (Person) inputStream.readObject();
            System.out.println("Восстановленный объект:");
            System.out.println("Имя: " + restoredPerson.getName());
            System.out.println("Возраст: " + restoredPerson.getAge());
            System.out.println("Средний балл: " + restoredPerson.getAverageGrade());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при восстановлении объекта: " + e.getMessage());
        }
    }

    private static class Person implements Serializable {
        private final String name;
        private final int age;
        private final double averageGrade;

        public Person(String name, int age, double averageGrade) {
            this.name = name;
            this.age = age;
            this.averageGrade = averageGrade;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public double getAverageGrade() {
            return averageGrade;
        }
    }
}
