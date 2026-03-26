package lr3;

import java.util.Scanner;

public class Task5 {
    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    static class LinkedListFromHead {
        Node head;

        LinkedListFromHead() {
            head = null;
        }

        void add(int value) {
            Node newNode = new Node(value);
            if (head == null) {
                head = newNode;
            } else {
                newNode.next = head;
                head = newNode;
            }
        }

        void printList() {
            Node current = head;
            while (current != null) {
                System.out.print(current.value + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    static class LinkedListFromTail {
        Node head;
        Node tail;

        LinkedListFromTail() {
            head = null;
            tail = null;
        }

        void add(int value) {
            Node newNode = new Node(value);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        void printList() {
            Node current = head;
            while (current != null) {
                System.out.print(current.value + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество элементов: ");
        int n = scanner.nextInt();

        System.out.println("\nВведите " + n + " элементов:");

        LinkedListFromHead listFromHead = new LinkedListFromHead();
        System.out.println("\nСоздание списка добавлением с головы:");
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            listFromHead.add(value);
        }
        System.out.print("Результат: ");
        listFromHead.printList();

        LinkedListFromTail listFromTail = new LinkedListFromTail();
        System.out.println("\nСоздание списка добавлением с хвоста:");
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            listFromTail.add(value);
        }
        System.out.print("Результат: ");
        listFromTail.printList();

        scanner.close();
    }
}
