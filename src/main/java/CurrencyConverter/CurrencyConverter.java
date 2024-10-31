package CurrencyConverter;

import java.util.Map;
import java.util.HashMap;

public class CurrencyConverter {
    public final Map<String, Currency> CURRENCIES;

    public CurrencyConverter() {
        CURRENCIES = new HashMap<>();
        init();

    }

    public void init() {
        CURRENCIES.put("USD", new Currency("USD", 1.0));
        CURRENCIES.put("EUR", new Currency("EUR", 0.85));
        CURRENCIES.put("JPY", new Currency("JPY", 110.0));
        CURRENCIES.put("GBP", new Currency("GBP", 0.75));
        CURRENCIES.put("RUB", new Currency("RUB", 75.0));
    }

    public double convert(double amount, String fromCurrency, String toCurrency) {
        if (amount < 0) {
            throw new IllegalArgumentException("Сумма не может быть отрицательной.");
        }
        if (!CURRENCIES.containsKey(fromCurrency) || !CURRENCIES.containsKey(toCurrency)) {
            throw new IllegalArgumentException("Неверная валюта");
        }
        double baseAmount = amount / CURRENCIES.get(fromCurrency).exchangeRate();
        return baseAmount * CURRENCIES.get(toCurrency).exchangeRate();
    }

    public void displayInfo() {
        System.out.println("Доступные валюты:");
        for (String str : CURRENCIES.keySet()) {
            System.out.println(str);
        }
    }

}