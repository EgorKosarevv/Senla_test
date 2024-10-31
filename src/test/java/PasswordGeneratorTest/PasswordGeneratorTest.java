package PasswordGeneratorTest;

import PasswordGenerator.PasswordGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordGeneratorTest {

    @Test
    public void testPasswordLength() {
        PasswordGenerator generator = new PasswordGenerator(10);
        String password = generator.GeneratePass();
        assertEquals(10, password.length(), "Пароль должен быть длиной 10 символов");
    }

    @Test
    public void testPasswordContainsUppercase() {
        PasswordGenerator generator = new PasswordGenerator(10);
        String password = generator.GeneratePass();
        assertTrue(password.chars().anyMatch(Character::isUpperCase), "Пароль должен содержать хотя бы одну заглавную букву");
    }

    @Test
    public void testPasswordContainsLowercase() {
        PasswordGenerator generator = new PasswordGenerator(10);
        String password = generator.GeneratePass();
        assertTrue(password.chars().anyMatch(Character::isLowerCase), "Пароль должен содержать хотя бы одну строчную букву");
    }

    @Test
    public void testPasswordContainsDigit() {
        PasswordGenerator generator = new PasswordGenerator(10);
        String password = generator.GeneratePass();
        assertTrue(password.chars().anyMatch(Character::isDigit), "Пароль должен содержать хотя бы одну цифру");
    }

    @Test
    public void testPasswordContainsSpecialCharacter() {
        PasswordGenerator generator = new PasswordGenerator(10);
        String password = generator.GeneratePass();
        assertTrue(password.chars().anyMatch(ch -> "!@#$%^&*()-_=+[]{}|;:,.<>?".indexOf(ch) >= 0), "Пароль должен содержать хотя бы один специальный символ");
    }

    @Test
    public void testInvalidLengthThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new PasswordGenerator(5);
        }, "Длина пароля должна быть от 8 до 12 символов");

        assertThrows(IllegalArgumentException.class, () -> {
            new PasswordGenerator(15);
        }, "Длина пароля должна быть от 8 до 12 символов");
    }
}