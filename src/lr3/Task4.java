package lr3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Task4 {
    public static int solveWithArrayList(int n) {
        ArrayList<Integer> people = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            people.add(i);
        }

        int index = 0;
        while (people.size() > 1) {
            index = (index + 1) % people.size();
            people.remove(index);
        }

        return people.get(0);
    }

    public static int solveWithLinkedList(int n) {
        LinkedList<Integer> people = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            people.add(i);
        }

        int index = 0;
        while (people.size() > 1) {
            index = (index + 1) % people.size();
            people.remove(index);
        }

        return people.get(0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество человек (N): ");
        int n = scanner.nextInt();

        int resultArrayList = solveWithArrayList(n);
        int resultLinkedList = solveWithLinkedList(n);

        System.out.println("\nРезультат (ArrayList): " + resultArrayList);
        System.out.println("Результат (LinkedList): " + resultLinkedList);

        scanner.close();
    }
}
