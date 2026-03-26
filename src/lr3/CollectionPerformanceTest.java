package lr3;
import java.util.*;

public class CollectionPerformanceTest {

    private static final int ADD_REMOVE_SIZE = 10_000_000;
    private static final int GET_INDEX_SIZE = 10_000_000;

    public static void main(String[] args) {
        System.out.println("=== Сравнение производительности коллекций ===\n");

        // Тестирование операций добавления и удаления
        System.out.println("=== Тестирование операций с " + ADD_REMOVE_SIZE + " элементами ===\n");
        testAddRemoveOperations();

        // Тестирование операции получения по индексу
        System.out.println("\n=== Тестирование операции получения по индексу с " + GET_INDEX_SIZE + " элементами ===\n");
        testGetByIndexOperation();
    }

    private static void testAddRemoveOperations() {
        // Тестирование ArrayList
        System.out.println("ArrayList:");
        testArrayListOperations();
        System.out.println("HashSet: не поддерживает добавление/удаление в конец/начало/середину");
        System.out.println("LinkedHashMap: не поддерживает добавление/удаление в конец/начало/середину");
    }

    private static void testArrayListOperations() {
        // 1. Добавление в начало
        ArrayList<Integer> list1 = new ArrayList<>();
        fillList(list1, ADD_REMOVE_SIZE);
        long time1 = measureAddToBeginning(list1);
        System.out.println("  Добавление в начало: " + time1 + " мс");

        // 2. Добавление в конец
        ArrayList<Integer> list2 = new ArrayList<>();
        long time2 = measureAddToEnd(list2, ADD_REMOVE_SIZE);
        System.out.println("  Добавление в конец: " + time2 + " мс");

        // 3. Добавление в середину
        ArrayList<Integer> list3 = new ArrayList<>();
        fillList(list3, ADD_REMOVE_SIZE);
        long time3 = measureAddToMiddle(list3);
        System.out.println("  Добавление в середину: " + time3 + " мс");

        // 4. Удаление из начала
        ArrayList<Integer> list4 = new ArrayList<>();
        fillList(list4, ADD_REMOVE_SIZE);
        long time4 = measureRemoveFromBeginning(list4);
        System.out.println("  Удаление из начала: " + time4 + " мс");

        // 5. Удаление из конца
        ArrayList<Integer> list5 = new ArrayList<>();
        fillList(list5, ADD_REMOVE_SIZE);
        long time5 = measureRemoveFromEnd(list5);
        System.out.println("  Удаление из конца: " + time5 + " мс");

        // 6. Удаление из середины
        ArrayList<Integer> list6 = new ArrayList<>();
        fillList(list6, ADD_REMOVE_SIZE);
        long time6 = measureRemoveFromMiddle(list6);
        System.out.println("  Удаление из середины: " + time6 + " мс");
    }

    private static void testGetByIndexOperation() {
        // Тестирование ArrayList
        ArrayList<Integer> arrayList = new ArrayList<>();
        fillList(arrayList, GET_INDEX_SIZE);
        long arrayListTime = measureGetByIndex(arrayList);
        System.out.println("ArrayList (получение по индексу): " + arrayListTime + " мс");

        // HashSet и LinkedHashMap не поддерживают получение по индексу
        System.out.println("HashSet: не поддерживает получение по индексу");
        System.out.println("LinkedHashMap: не поддерживает получение по индексу");
    }

    // Вспомогательные методы для заполнения коллекций
    private static void fillList(ArrayList<Integer> list, int size) {
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
    }

    // Методы измерения для ArrayList
    private static long measureAddToBeginning(ArrayList<Integer> list) {
        long start = System.currentTimeMillis();
        list.addFirst(-1);
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long measureAddToEnd(ArrayList<Integer> list, int size) {
        long start = System.currentTimeMillis();
        list.addLast(-1);
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long measureAddToMiddle(ArrayList<Integer> list) {
        long start = System.currentTimeMillis();
        list.add(list.size() / 2, -1);
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long measureRemoveFromBeginning(ArrayList<Integer> list) {
        long start = System.currentTimeMillis();
        list.removeFirst();
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long measureRemoveFromEnd(ArrayList<Integer> list) {
        long start = System.currentTimeMillis();
        list.removeLast();
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long measureRemoveFromMiddle(ArrayList<Integer> list) {
        long start = System.currentTimeMillis();
        list.remove(list.size() / 2);
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long measureGetByIndex(ArrayList<Integer> list) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < GET_INDEX_SIZE; i++) {
            list.get(i);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }
}