import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Calculator {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, Double> items = new HashMap<>();

    public void startCalculation() {
        int numberOfPeople = getNumberOfPeople();

        collectItems();
        calculateAndPrintResults(numberOfPeople);
    }

    private int getNumberOfPeople() {
        int numberOfPeople = 0;

        while (true) {
            System.out.println("Введите количество гостей для разделения счета:");

            try {
                numberOfPeople = Integer.parseInt(scanner.next());

                if (numberOfPeople > 1) {
                    break;
                } else {
                    System.out.println("Ошибка: Введите корректное количество гостей (больше 1).");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Введите число.");
            }
        }

        return numberOfPeople;
    }

    private void collectItems() {
        while (true) {
            System.out.println("Введите название товара или 'Завершить', чтобы закончить:");
            String itemName = scanner.next();

            if (itemName.equalsIgnoreCase("Завершить")) {
                break;
            }

            double itemPrice = getItemPrice();
            if (itemPrice < 0) {
                System.out.println("Некорректная стоимость товара. Попробуйте снова.");
                continue;
            }

            addItem(itemName, itemPrice);
            System.out.println("Товар успешно добавлен.");
        }
    }

    private double getItemPrice() {
        double itemPrice = 0;

        while (true) {
            System.out.println("Введите стоимость товара:");

            try {
                itemPrice = Double.parseDouble(scanner.next());

                if (itemPrice >= 0) {
                    break;
                } else {
                    System.out.println("Ошибка: Введите положительное число.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Введите корректное число.");
            }
        }

        return itemPrice;
    }

    private void addItem(String itemName, double itemPrice) {
        items.put(itemName, itemPrice);
    }

    private void calculateAndPrintResults(int numberOfPeople) {
        double totalCost = 0.00;
        for (double price : items.values()) {
            totalCost += price;
        }

        System.out.println("Добавленные товары:");
        items.forEach((itemName, itemPrice) ->
                System.out.println(itemName + ": " + Formatter.formatCurrency(itemPrice)));

        double costPerPerson = totalCost / numberOfPeople;
        System.out.println("Сумма для каждого человека: " + Formatter.formatCurrency(costPerPerson));
    }
}
