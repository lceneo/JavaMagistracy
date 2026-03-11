package lr2;

// Интерфейс для работы с банковскими счетами
interface BankAccountInterface {
    void deposit(double amount);           // внесение денег на счёт
    boolean withdraw(double amount);       // снятие денег со счёта
    double getBalance();                   // получение текущего баланса
    String getAccountInfo();               // информация о счёте
}

// Класс Банковский счёт
class BankAccount implements BankAccountInterface {
    private String accountNumber;  // номер счёта
    private String ownerName;      // имя владельца
    private double balance;        // текущий баланс

    // Конструктор
    public BankAccount(String accountNumber, String ownerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }

    // Внесение денег на счёт
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Внесено: " + amount + " руб.");
        } else {
            System.out.println("Сумма должна быть положительной");
        }
    }

    // Снятие денег со счёта
    @Override
    public boolean withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("Снято: " + amount + " руб.");
                return true;
            } else {
                System.out.println("Недостаточно средств на счёте");
                return false;
            }
        } else {
            System.out.println("Сумма должна быть положительной");
            return false;
        }
    }

    // Получение текущего баланса
    @Override
    public double getBalance() {
        return balance;
    }

    // Информация о счёте
    @Override
    public String getAccountInfo() {
        return "Счёт №" + accountNumber + " | Владелец: " + ownerName + " | Баланс: " + balance + " руб.";
    }

    // Геттеры
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }
}

public class Task7 {
    public static void main(String[] args) {
        // Создание объектов банковских счетов
        BankAccount account1 = new BankAccount("1234567890", "Иванов И.И.", 10000.0);
        BankAccount account2 = new BankAccount("0987654321", "Петров П.П.", 5000.0);

        // Вывод информации о счетах
        System.out.println("=== Информация о счетах ===");
        System.out.println(account1.getAccountInfo());
        System.out.println(account2.getAccountInfo());

        // Транзакции для первого счёта
        System.out.println("\n=== Транзакции для счёта " + account1.getAccountNumber() + " ===");
        account1.deposit(5000.0);
        System.out.println("Баланс: " + account1.getBalance() + " руб.");
        account1.withdraw(3000.0);
        System.out.println("Баланс: " + account1.getBalance() + " руб.");
        account1.withdraw(50000.0); // попытка снять больше, чем есть

        // Транзакции для второго счёта
        System.out.println("\n=== Транзакции для счёта " + account2.getAccountNumber() + " ===");
        account2.deposit(2000.0);
        System.out.println("Баланс: " + account2.getBalance() + " руб.");
        account2.withdraw(1000.0);
        System.out.println("Баланс: " + account2.getBalance() + " руб.");

        // Итоговая информация
        System.out.println("\n=== Итоговая информация ===");
        System.out.println(account1.getAccountInfo());
        System.out.println(account2.getAccountInfo());
    }
}
