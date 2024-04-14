import java.util.*;

public class Main {
    private static final String[] WORDS = {"HELLO", "WORLD", "JAVA", "COMPUTER", "PROGRAMMING"};
    private static final int MAX_TRIES = 6;

    private String wordToGuess;
    private StringBuilder currentGuess;
    private Set<Character> guessedLetters;
    private int remainingTries;

    public Main () {
        Random random = new Random();
        wordToGuess = WORDS[random.nextInt(WORDS.length)].toUpperCase();
        currentGuess = new StringBuilder(wordToGuess.length());
        for (int i = 0; i < wordToGuess.length(); i++) {
            currentGuess.append('_');
        }
        guessedLetters = new HashSet<>();
        remainingTries = MAX_TRIES;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Hangman!");

        while (remainingTries > 0 && currentGuess.indexOf("_") != -1) {
            System.out.println("Word: " + currentGuess);
            System.out.println("Remaining tries: " + remainingTries);
            System.out.print("Enter a letter: ");
            char letter = scanner.next().toUpperCase().charAt(0);

            if (!Character.isLetter(letter)) {
                System.out.println("Please enter a valid letter.");
                continue;
            }

            if (guessedLetters.contains(letter)) {
                System.out.println("You've already guessed that letter.");
                continue;
            }

            guessedLetters.add(letter);

            if (wordToGuess.contains(String.valueOf(letter))) {
                for (int i = 0; i < wordToGuess.length(); i++) {
                    if (wordToGuess.charAt(i) == letter) {
                        currentGuess.setCharAt(i, letter);
                    }
                }
                System.out.println("Correct guess!");
            } else {
                remainingTries--;
                System.out.println("Incorrect guess.");
            }
        }

        if (remainingTries == 0) {
            System.out.println("You've run out of tries. The word was: " + wordToGuess);
        } else {
            System.out.println("Congratulations! You've guessed the word: " + wordToGuess);
        }

        scanner.close();
    }

    public static void main(String[] args) {
        Main  hangman = new Main ();
        hangman.play();
    }
}
