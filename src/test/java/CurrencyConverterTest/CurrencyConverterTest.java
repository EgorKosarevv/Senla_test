package CurrencyConverterTest;

import CurrencyConverter.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CurrencyConverterTest {

    @Test
    public void testInitialization() {
        CurrencyConverter converter = new CurrencyConverter();
        assertNotNull(converter);
        assertEquals(5, converter.CURRENCIES.size(), "Должно быть 5 доступных валют");
    }

    @Test
    public void testConvertValid() {
        CurrencyConverter converter = new CurrencyConverter();
        double amountInUSD = 100.0;
        double expectedAmountInEUR = amountInUSD * 0.85;
        double convertedAmount = converter.convert(amountInUSD, "USD", "EUR");
        assertEquals(expectedAmountInEUR, convertedAmount, 0.01);
    }

    @Test
    public void testConvertInvalidCurrency() {
        CurrencyConverter converter = new CurrencyConverter();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            converter.convert(100.0, "USD", "INVALID");
        });
        assertEquals("Неверная валюта", exception.getMessage());
    }

    @Test
    public void testConvertNegativeAmount() {
        CurrencyConverter converter = new CurrencyConverter();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            converter.convert(-100.0, "USD", "EUR");
        });
        assertEquals("Сумма не может быть отрицательной.", exception.getMessage());
    }

    @Test
    public void testDisplayInfo() {
        CurrencyConverter converter = new CurrencyConverter();
        assertTrue(converter.CURRENCIES.containsKey("USD"));
        assertTrue(converter.CURRENCIES.containsKey("EUR"));
        assertTrue(converter.CURRENCIES.containsKey("JPY"));
        assertTrue(converter.CURRENCIES.containsKey("GBP"));
        assertTrue(converter.CURRENCIES.containsKey("RUB"));
    }
}