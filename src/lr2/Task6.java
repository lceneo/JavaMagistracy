package lr2;

// Интерфейс для геометрических фигур
interface Shape {
    double getArea();      // вычисление площади
    double getPerimeter(); // вычисление периметра
    String getName();      // название фигуры
}

// Класс Круг
class Circle implements Shape {
    private double radius; // радиус

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String getName() {
        return "Круг";
    }
}

// Класс Квадрат
class Square implements Shape {
    private double side; // сторона

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }

    @Override
    public String getName() {
        return "Квадрат";
    }
}

// Класс Треугольник (равносторонний для простоты)
class Triangle implements Shape {
    private double a; // сторона a
    private double b; // сторона b
    private double c; // сторона c

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    @Override
    public double getArea() {
        // Формула Герона
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }

    @Override
    public String getName() {
        return "Треугольник";
    }
}

public class Task6 {
    public static void main(String[] args) {
        // Создание объектов фигур
        Shape circle = new Circle(5.0);
        Shape square = new Square(4.0);
        Shape triangle = new Triangle(3.0, 4.0, 5.0);

        // Вывод информации о фигурах
        printShapeInfo(circle);
        printShapeInfo(square);
        printShapeInfo(triangle);
    }

    // Метод для вывода информации о фигуре
    public static void printShapeInfo(Shape shape) {
        System.out.println(shape.getName() + ":");
        System.out.printf("  Площадь: %.2f%n", shape.getArea());
        System.out.printf("  Периметр: %.2f%n%n", shape.getPerimeter());
    }
}
