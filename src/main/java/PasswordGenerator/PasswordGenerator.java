package PasswordGenerator;

import java.security.SecureRandom;

public class PasswordGenerator {
    private static final String UPPERSTRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERSTRING = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:,.<>?";

    private final int LENGTH;
    private final SecureRandom RANDOM = new SecureRandom();

    public PasswordGenerator(int LENGTH) {
        if (LENGTH < 8 || LENGTH > 12) {
            throw new IllegalArgumentException("Длина пароля должна быть от 8 до 12 символов");
        }
        this.LENGTH = LENGTH;
    }

    public String GeneratePass() {
        StringBuilder password = new StringBuilder(LENGTH);

        password.append(randomChar(UPPERSTRING));
        password.append(randomChar(LOWERSTRING));
        password.append(randomChar(DIGITS));
        password.append(randomChar(SPECIAL_CHARACTERS));

        String AllCharacters = UPPERSTRING + LOWERSTRING + DIGITS + SPECIAL_CHARACTERS;
        for (int i = 4; i < LENGTH; i++) {
            password.append(AllCharacters.charAt(RANDOM.nextInt(AllCharacters.length())));
        }

        return Mixing(password.toString());
    }

    private char randomChar(String characters) {
        return characters.charAt(RANDOM.nextInt(characters.length()));
    }

    public String Mixing(String str) {
        char[] characters = str.toCharArray();
        SecureRandom random = new SecureRandom();

        for (int i = characters.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            char temp = characters[i];
            characters[i] = characters[j];
            characters[j] = temp;
        }

        return new String(characters);
    }
}