package HangmanGameTest;

import HangmanGame.Player;
import HangmanGame.Word;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    private Player player;
    private Word word;

    @BeforeEach
    public void setUp() {
        player = new Player(3);
        word = new Word("HELLO");
    }

    @Test
    public void testGuessLetterNewLetter() {
        assertTrue(player.guessLetter('H'), "Буква 'H' должна быть успешно отгадана");
        assertTrue(player.guessLetter('E'), "Буква 'E' должна быть успешно отгадана");

        String actualGuessedLetters = player.getGuessedLetters();
        assertTrue(actualGuessedLetters.contains("H"), "Угаданные буквы должны содержать 'H'");
        assertTrue(actualGuessedLetters.contains("E"), "Угаданные буквы должны содержать 'E'");
    }

    @Test
    public void testGuessLetterAlreadyGuessed() {
        player.guessLetter('H');
        assertFalse(player.guessLetter('H'), "Буква 'H' уже была угадана, должно вернуть false");
    }

    @Test
    public void testLoseLife() {
        assertTrue(player.hasAttemptsLeft(), "Игрок должен иметь попытки");

        player.loseLife();
        assertEquals(2, player.getAttemptsLeft(), "После одной потери жизни должно остаться 2 попытки");

        player.loseLife();
        assertEquals(1, player.getAttemptsLeft(), "После второй потери жизни должно остаться 1 попытка");

        player.loseLife();
        assertFalse(player.hasAttemptsLeft(), "После третьей потери жизни игрок не должен иметь попыток");
    }

    @Test
    public void testHasGuessedAllLettersTrue() {
        player.guessLetter('H');
        player.guessLetter('E');
        player.guessLetter('L');
        player.guessLetter('O');

        assertTrue(player.hasGuessedAllLetters(word), "Игрок должен угадать все буквы слова 'HELLO'");
    }

    @Test
    public void testHasGuessedAllLettersFalse() {
        player.guessLetter('H');
        player.guessLetter('E');

        assertFalse(player.hasGuessedAllLetters(word), "Игрок не должен угадать все буквы слова 'HELLO'");
    }
}
