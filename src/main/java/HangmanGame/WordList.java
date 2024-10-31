package HangmanGame;

public enum WordList {
    APPLE,
    BRAVE,
    CHART,
    DRAMA,
    ELITE,
    FLAME,
    GRAPE,
    HONEY,
    IGLOO,
    JOKER,
    KITES,
    LEMON,
    MANGO,
    NUTTY,
    OCEAN,
    PEARL,
    QUEEN,
    STORM,
    TIGER;

    public static String getRandomWord() {
        WordList[] words = values();
        int randomIndex = (int) (Math.random() * words.length);
        return words[randomIndex].name();
    }
}