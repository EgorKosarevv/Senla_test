package HangmanGame;

import java.util.Scanner;

public class HangmanGame {
    private final Word CURRENT_WORD;
    private final Player PLAYER;

    private static final String[] HANGMAN_STATES = {
            "  \n  \n  \n  \n  \n  \n",
            "  O\n  \n  \n  \n  \n  \n",
            "  O\n  |\n  \n  \n  \n  \n",
            "  O\n /|\n  \n  \n  \n  \n",
            "  O\n /|\\\n  \n  \n  \n  \n",
            "  O\n /|\\\n / \n  \n  \n  \n",
            "Игра окончена! Загаданное слово было: "
    };

    public HangmanGame() {
        CURRENT_WORD = new Word(WordList.getRandomWord());
        PLAYER = new Player(6);
    }

    public void play() {
        System.out.println("Добро пожаловать в игру 'Виселица'!");

        Scanner scanner = new Scanner(System.in);

        while (PLAYER.hasAttemptsLeft() && !PLAYER.hasGuessedAllLetters(CURRENT_WORD)) {
            System.out.println("\nТекущее слово: " + displayCurrentState());
            System.out.println("Попыток осталось: " + PLAYER.getAttemptsLeft());
            System.out.println(drawHangman()); // Отображение состояния виселицы
            System.out.print("Угадайте букву: ");
            String input = scanner.nextLine().toUpperCase();

            if (input.length() > 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("Пожалуйста, введите одну букву.");
                continue;
            }

            char guess = input.charAt(0);

            if (PLAYER.guessLetter(guess)) {
                if (!CURRENT_WORD.contains(guess)) {
                    PLAYER.loseLife();
                } else {
                    System.out.println("Хорошо! Буква '" + guess + "' есть в слове.");
                }
            }
        }

        if (PLAYER.hasGuessedAllLetters(CURRENT_WORD)) {
            System.out.println("Поздравляем! Вы угадали слово: " + CURRENT_WORD.getWordToGuess());
        } else {
            System.out.println(HANGMAN_STATES[HANGMAN_STATES.length - 1] + CURRENT_WORD.getWordToGuess());
        }

        scanner.close();
    }

    private String displayCurrentState() {
        StringBuilder displayedWord = new StringBuilder();
        for (char letter : CURRENT_WORD.getWordToGuess().toCharArray()) {
            displayedWord.append(PLAYER.getGuessedLetters().indexOf(letter) >= 0 ? letter : '_').append(' ');
        }
        return displayedWord.toString().trim();
    }

    private String drawHangman() {
        int livesLeft = PLAYER.getAttemptsLeft();
        return HANGMAN_STATES[6 - livesLeft]; 
    }
}