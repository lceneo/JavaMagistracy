package lr2;

// Базовый класс Animal (животное)
class Animal {
    protected String name;  // имя
    protected int age;      // возраст

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Метод для издания звука
    public void makeSound() {
        System.out.println("Животное издаёт звук");
    }

    // Метод для вывода информации
    public void getInfo() {
        System.out.println("Имя: " + name + ", Возраст: " + age);
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

// Подкласс Dog (собака)
class Dog extends Animal {
    private String breed;  // порода

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println(name + " лает: Гав-гав!");
    }

    public void fetch() {
        System.out.println(name + " приносит мяч");
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Порода: " + breed);
    }
}

// Подкласс Cat (кот)
class Cat extends Animal {
    private String foodType;  // тип корма

    public Cat(String name, int age, String foodType) {
        super(name, age);
        this.foodType = foodType;
    }

    @Override
    public void makeSound() {
        System.out.println(name + " мяукает: Мяу-мяу!");
    }

    public void scratch() {
        System.out.println(name + " точит когти");
    }

    public String getFoodType() {
        return foodType;
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Тип корма: " + foodType);
    }
}

// Подкласс Bird (птица)
class Bird extends Animal {
    private boolean canFly;  // способность летать

    public Bird(String name, int age, boolean canFly) {
        super(name, age);
        this.canFly = canFly;
    }

    @Override
    public void makeSound() {
        System.out.println(name + " поёт: Чик-чирик!");
    }

    public void fly() {
        if (canFly) {
            System.out.println(name + " летит");
        } else {
            System.out.println(name + " не может летать");
        }
    }

    public boolean isCanFly() {
        return canFly;
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Способность летать: " + (canFly ? "да" : "нет"));
    }
}

public class Task8 {
    public static void main(String[] args) {
        System.out.println("=== Работа с животными ===\n");

        // Создание объектов
        Dog dog = new Dog("Бобик", 3, "Овчарка");
        Cat cat = new Cat("Мурзик", 5, "Сухой корм");
        Bird bird = new Bird("Кеша", 2, true);

        // Вызов методов
        System.out.println("--- Собака ---");
        dog.getInfo();
        dog.makeSound();
        dog.fetch();

        System.out.println("\n--- Кот ---");
        cat.getInfo();
        cat.makeSound();
        cat.scratch();

        System.out.println("\n--- Птица ---");
        bird.getInfo();
        bird.makeSound();
        bird.fly();

        // Демонстрация полиморфизма
        System.out.println("\n=== Полиморфизм ===");
        Animal[] animals = {dog, cat, bird};
        for (Animal animal : animals) {
            animal.makeSound();
        }
    }
}
