package HangmanGame;
import java.util.HashSet;
import java.util.Set;

public class Player {
    private final Set<Character> GUESSED_LETTERS;
    private int attemptsLeft;

    public Player(int maxAttempts) {
        this.GUESSED_LETTERS = new HashSet<>();
        this.attemptsLeft = maxAttempts;
    }

    public boolean guessLetter(char letter) {
        if (GUESSED_LETTERS.contains(letter)) {
            System.out.println("Вы уже угадали букву " + letter);
            return false;
        }
        GUESSED_LETTERS.add(letter);
        return true;
    }

    public void loseLife() {
        attemptsLeft--;
        System.out.println("Неверный ответ! Осталось попыток: " + attemptsLeft);
    }

    public boolean hasAttemptsLeft() {
        return attemptsLeft > 0;
    }

    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    public boolean hasGuessedAllLetters(Word word) {
        for (char letter : word.getWordToGuess().toCharArray()) {
            if (!GUESSED_LETTERS.contains(letter)) {
                return false;
            }
        }
        return true;
    }

    public String getGuessedLetters() {
        StringBuilder sb = new StringBuilder();
        for (char letter : GUESSED_LETTERS) {
            sb.append(letter).append(' ');
        }
        return sb.toString().trim();
    }
}
