package lr2;

public class Task5 {
    public static void main(String[] args) {
        // Создание объекта Rectangle с использованием конструктора
        Rectangle rectangle = new Rectangle(5.0, 3.0);

        // Вывод информации о прямоугольнике
        System.out.println("Длина: " + rectangle.getLength());
        System.out.println("Ширина: " + rectangle.getWidth());
        System.out.println("Площадь: " + rectangle.getArea());
        System.out.println("Периметр: " + rectangle.getPerimeter());

        // Изменение значений полей
        rectangle.setLength(7.0);
        rectangle.setWidth(4.0);
        System.out.println("\nНовые значения:");
        System.out.println("Длина: " + rectangle.getLength());
        System.out.println("Ширина: " + rectangle.getWidth());
        System.out.println("Площадь: " + rectangle.getArea());
        System.out.println("Периметр: " + rectangle.getPerimeter());
    }
}

class Rectangle {
    private double length;  // длина
    private double width;   // ширина

    // Конструктор
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Геттеры и сеттеры для длины
    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    // Геттеры и сеттеры для ширины
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    // Метод для вычисления площади
    public double getArea() {
        return length * width;
    }

    // Метод для вычисления периметра
    public double getPerimeter() {
        return 2 * (length + width);
    }
}
