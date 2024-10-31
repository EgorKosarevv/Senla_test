package CurrencyConverter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CurrencyConverter converter = new CurrencyConverter();

        converter.displayInfo();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите сумму: ");
            double amount = scanner.nextDouble();

            System.out.print("Введите валюту из которой конвертируете (например, USD): ");
            String fromCurrency = scanner.next().toUpperCase();

            System.out.print("Введите валюту в которую конвертируете (например, EUR): ");
            String toCurrency = scanner.next().toUpperCase();

            double convertedAmount = converter.convert(amount, fromCurrency, toCurrency);
            System.out.printf("%.2f %s = %.2f %s%n", amount, fromCurrency, convertedAmount, toCurrency);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}