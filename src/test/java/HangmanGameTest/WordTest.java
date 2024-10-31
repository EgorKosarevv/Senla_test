package HangmanGameTest;

import HangmanGame.Word;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WordTest {
    private Word word;

    @BeforeEach
    public void setUp() {
        word = new Word("HELLO");
    }

    @Test
    public void testGetWordToGuess() {
        assertEquals("HELLO", word.getWordToGuess(), "Слово должно быть 'HELLO'");
    }

    @Test
    public void testContainsLetterPresent() {
        assertTrue(word.contains('H'), "Слово должно содержать букву 'H'");
        assertTrue(word.contains('E'), "Слово должно содержать букву 'E'");
        assertTrue(word.contains('L'), "Слово должно содержать букву 'L'");
        assertTrue(word.contains('O'), "Слово должно содержать букву 'O'");
    }

    @Test
    public void testContainsLetterNotPresent() {
        assertFalse(word.contains('A'), "Слово не должно содержать букву 'A'");
        assertFalse(word.contains('Z'), "Слово не должно содержать букву 'Z'");
    }
}
