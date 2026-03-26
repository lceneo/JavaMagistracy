package lr3;

public class Example5 {
    public static void main(String[] args) {
        System.out.println("Последовательность обхода:");
        System.out.println("Результат: " + fact(5));
    }

    public static int fact(int n) {
        System.out.print("fact(" + n + ") ");
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fact(n - 2) + fact(n - 1);
        }
    }
}
