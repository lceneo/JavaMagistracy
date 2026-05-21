package lr7.timus.task_1084;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double side = scanner.nextDouble();
        double rope = scanner.nextDouble();
        double halfSide = side / 2.0;

        double area;
        if (rope <= halfSide) {
            area = Math.PI * rope * rope;
        } else if (rope >= halfSide * Math.sqrt(2.0)) {
            area = side * side;
        } else {
            double x = Math.sqrt(rope * rope - halfSide * halfSide);
            area = 4.0 * (halfSide * x + integral(rope, halfSide) - integral(rope, x));
        }

        System.out.printf(Locale.US, "%.3f%n", area);
    }

    private static double integral(double radius, double x) {
        return 0.5 * (x * Math.sqrt(radius * radius - x * x)
                + radius * radius * Math.asin(x / radius));
    }
}
