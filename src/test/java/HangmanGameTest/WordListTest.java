package HangmanGameTest;

import HangmanGame.WordList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

public class WordListTest {

    @Test
    public void testGetRandomWord() {
        String randomWord = WordList.getRandomWord();
        assertNotNull(randomWord, "Слово не должно быть null");

        Set<String> validWords = new HashSet<>();
        for (WordList word : WordList.values()) {
            validWords.add(word.name());
        }

        assertTrue(validWords.contains(randomWord), "Слово должно быть одним из: " + validWords);
    }
}
