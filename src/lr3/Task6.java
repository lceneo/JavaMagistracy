package lr3;

import java.util.Scanner;

public class Task6 {
    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    static class LinkedList {
        Node head;
        Node tail;
        int size;

        LinkedList() {
            head = null;
            tail = null;
            size = 0;
        }

        // === Методы с использованием цикла ===

        public void createHead(Scanner scanner) {
            System.out.print("Введите количество элементов: ");
            int n = scanner.nextInt();
            System.out.println("Введите " + n + " элементов (с головы):");
            for (int i = 0; i < n; i++) {
                int value = scanner.nextInt();
                addFirst(value);
            }
        }

        public void createTail(Scanner scanner) {
            System.out.print("Введите количество элементов: ");
            int n = scanner.nextInt();
            System.out.println("Введите " + n + " элементов (с хвоста):");
            for (int i = 0; i < n; i++) {
                int value = scanner.nextInt();
                addLast(value);
            }
        }

        public String toStringIterative() {
            StringBuilder sb = new StringBuilder();
            Node current = head;
            while (current != null) {
                sb.append(current.value);
                if (current.next != null) {
                    sb.append(" -> ");
                }
                current = current.next;
            }
            return sb.toString();
        }

        public void addFirst(int value) {
            Node newNode = new Node(value);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.next = head;
                head = newNode;
            }
            size++;
        }

        public void addLast(int value) {
            Node newNode = new Node(value);
            if (tail == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            size++;
        }

        public void insert(int position, int value) {
            if (position < 0 || position > size) {
                System.out.println("Некорректная позиция!");
                return;
            }
            if (position == 0) {
                addFirst(value);
                return;
            }
            if (position == size) {
                addLast(value);
                return;
            }

            Node newNode = new Node(value);
            Node current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }

        public int removeFirst() {
            if (head == null) {
                System.out.println("Список пуст!");
                return -1;
            }
            int value = head.value;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            size--;
            return value;
        }

        public int removeLast() {
            if (head == null) {
                System.out.println("Список пуст!");
                return -1;
            }
            if (head == tail) {
                int value = head.value;
                head = null;
                tail = null;
                size--;
                return value;
            }
            Node current = head;
            while (current.next != tail) {
                current = current.next;
            }
            int value = tail.value;
            tail = current;
            tail.next = null;
            size--;
            return value;
        }

        public int remove(int position) {
            if (position < 0 || position >= size) {
                System.out.println("Некорректная позиция!");
                return -1;
            }
            if (position == 0) {
                return removeFirst();
            }
            if (position == size - 1) {
                return removeLast();
            }

            Node current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.next;
            }
            int value = current.next.value;
            current.next = current.next.next;
            size--;
            return value;
        }

        // === Методы с использованием рекурсии ===

        public void createHeadRec(Scanner scanner) {
            System.out.print("Введите количество элементов: ");
            int n = scanner.nextInt();
            System.out.println("Введите " + n + " элементов (с головы, рекурсивно):");
            head = createHeadRecHelper(scanner, n);
            size = n;
            tail = getLastNode();
        }

        private Node createHeadRecHelper(Scanner scanner, int n) {
            if (n == 0) {
                return null;
            }
            int value = scanner.nextInt();
            Node node = new Node(value);
            node.next = createHeadRecHelper(scanner, n - 1);
            return node;
        }

        public void createTailRec(Scanner scanner) {
            System.out.print("Введите количество элементов: ");
            int n = scanner.nextInt();
            System.out.println("Введите " + n + " элементов (с хвоста, рекурсивно):");
            int[] values = new int[n];
            readValuesRec(scanner, values, 0);
            head = createTailRecHelper(values, 0);
            size = n;
            tail = getLastNode();
        }

        private void readValuesRec(Scanner scanner, int[] values, int index) {
            if (index >= values.length) {
                return;
            }
            values[index] = scanner.nextInt();
            readValuesRec(scanner, values, index + 1);
        }

        private Node createTailRecHelper(int[] values, int index) {
            if (index >= values.length) {
                return null;
            }
            Node node = new Node(values[index]);
            node.next = createTailRecHelper(values, index + 1);
            return node;
        }

        public String toStringRec() {
            return toStringRecHelper(head);
        }

        private String toStringRecHelper(Node node) {
            if (node == null) {
                return "";
            }
            if (node.next == null) {
                return String.valueOf(node.value);
            }
            return node.value + " -> " + toStringRecHelper(node.next);
        }

        private Node getLastNode() {
            if (head == null) {
                return null;
            }
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            return current;
        }

        public int getSize() {
            return size;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList list = new LinkedList();

        while (true) {
            System.out.println("\n=== Меню ===");
            System.out.println("1. Ввод с головы (цикл)");
            System.out.println("2. Ввод с хвоста (цикл)");
            System.out.println("3. Вывод (цикл)");
            System.out.println("4. Добавить в начало");
            System.out.println("5. Добавить в конец");
            System.out.println("6. Вставить по позиции");
            System.out.println("7. Удалить с головы");
            System.out.println("8. Удалить с хвоста");
            System.out.println("9. Удалить по позиции");
            System.out.println("10. Ввод с головы (рекурсия)");
            System.out.println("11. Ввод с хвоста (рекурсия)");
            System.out.println("12. Вывод (рекурсия)");
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    list = new LinkedList();
                    list.createHead(scanner);
                    break;
                case 2:
                    list = new LinkedList();
                    list.createTail(scanner);
                    break;
                case 3:
                    System.out.println("Список: " + list.toStringIterative());
                    break;
                case 4:
                    System.out.print("Введите значение: ");
                    list.addFirst(scanner.nextInt());
                    break;
                case 5:
                    System.out.print("Введите значение: ");
                    list.addLast(scanner.nextInt());
                    break;
                case 6:
                    System.out.print("Введите позицию: ");
                    int pos = scanner.nextInt();
                    System.out.print("Введите значение: ");
                    int val = scanner.nextInt();
                    list.insert(pos, val);
                    break;
                case 7:
                    int removedFirst = list.removeFirst();
                    if (removedFirst != -1) {
                        System.out.println("Удалён элемент: " + removedFirst);
                    }
                    break;
                case 8:
                    int removedLast = list.removeLast();
                    if (removedLast != -1) {
                        System.out.println("Удалён элемент: " + removedLast);
                    }
                    break;
                case 9:
                    System.out.print("Введите позицию: ");
                    int removePos = scanner.nextInt();
                    int removed = list.remove(removePos);
                    if (removed != -1) {
                        System.out.println("Удалён элемент: " + removed);
                    }
                    break;
                case 10:
                    list = new LinkedList();
                    list.createHeadRec(scanner);
                    break;
                case 11:
                    list = new LinkedList();
                    list.createTailRec(scanner);
                    break;
                case 12:
                    System.out.println("Список: " + list.toStringRec());
                    break;
                case 0:
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Некорректный выбор!");
            }
        }
    }
}
