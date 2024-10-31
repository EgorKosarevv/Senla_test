package HangmanGame;

public class Word {
    private final String WORD_TO_GUESS;

    public Word(String word) {
        this.WORD_TO_GUESS = word;
    }

    public String getWordToGuess() {
        return WORD_TO_GUESS;
    }

    public boolean contains(char letter) {
        return WORD_TO_GUESS.indexOf(letter) >= 0;
    }
}
