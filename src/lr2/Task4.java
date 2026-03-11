package lr2;

public class Task4 {
    public static void main(String[] args) {
        // Создание объекта Person с использованием конструктора
        Person person = new Person("Иван", 25, "Мужской");

        // Вывод информации о человеке
        System.out.println("Имя: " + person.getName());
        System.out.println("Возраст: " + person.getAge());
        System.out.println("Пол: " + person.getGender());

        // Изменение значений полей с помощью сеттеров
        person.setAge(26);
        System.out.println("\nНовый возраст: " + person.getAge());
    }
}

class Person {
    private String name;    // имя
    private int age;        // возраст
    private String gender;  // пол

    // Конструктор
    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // Геттеры и сеттеры для имени
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Геттеры и сеттеры для возраста
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Геттеры и сеттеры для пола
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
