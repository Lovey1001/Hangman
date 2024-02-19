package ui;

import model.Hangman;
import model.WordList;
import java.util.List;
import java.util.Scanner;

//  Hangman Game application in Console.
// Used the TellerApp application for some code functions.
public class HangmanGame {

    private final Scanner scanner = new Scanner(System.in);
    private final WordList wordList;

    // EFFECTS: runs the hangman game
    public HangmanGame(WordList wordList) {
        this.wordList = wordList;
    }

    // REQUIRES: no numbers or special characters allowed
    // EFFECTS: displays the words inputted by user and added to list
    public void addWordsMenu() {

        System.out.println("Please add words to the list. Type 'done' when finished:");

        while (true) {
            String word = scanner.nextLine().trim();
            if ("done".equalsIgnoreCase(word)) {
                break;
            }
            if (!word.isEmpty() && word.matches("^[a-zA-Z]+$")) {
                if (wordList.containsWordInList(word)) {
                    System.out.println("This word already exists. Please enter a different word or type 'done':");
                } else {
                    wordList.addWordToList(word);
                    System.out.println("Word added. Add another word or type 'done':");
                }
            } else {
                System.out.println("Please add an appropriate word or type 'done':");
            }
        }
        listOfWordsAddedMenu();
    }

    // EFFECTS: displays the list of words added; works tandem with displayWordsMenu()
    public void listOfWordsAddedMenu() {
        System.out.println("Would you like to view the list of added words? (yes/no)");
        String answer = scanner.nextLine().trim().toLowerCase();
        if ("yes".equalsIgnoreCase(answer)) {
            displayWordsMenu();
        }
    }

    // EFFECTS: processes user input and runs the application
    public void startGame() {
        boolean keepGoing = true;

        addWordsMenu();

        while (keepGoing) {

            String wordToGuess = wordList.getRandomWordSelected();
            Hangman gameState = new Hangman(wordToGuess);

            if (wordToGuess == null) {
                System.out.println("All words have been used. Game over.");
                break;
            }

            while (!gameState.isGameOver()) {
                displayHangmanGame(gameState);
                char guess = guessLetterMenu();
                gameState.guessNextLetter(guess);
            }

            displayEndGame(gameState.isGameOver() && gameState.wordGuessed(), wordToGuess);
            wordList.addWordToList(wordToGuess);

            keepGoing = playNextRound();
        }
    }

    // EFFECTS: asks player if they want to continue playing or quit
    public boolean playNextRound() {
        System.out.println("\nDo you want to continue playing? (yes/no)");
        String input = scanner.nextLine().trim().toLowerCase();
        return input.equals("yes");
    }

    // EFFECTS: displays the current game state after word is selected at random
    public void displayHangmanGame(Hangman hangman) {
        System.out.println("\nCurrent word: " + hangman.getWordWithGuesses());
        System.out.println("Attempts left: " + hangman.numberOfLivesLeft());
        System.out.println("Guessed letters: " + hangman.getGuessedLetters());
    }

    // EFFECTS: prompts users to guess a letter and displays a list of all letters guessed
    public char guessLetterMenu() {
        System.out.print("Guess a letter: ");
        String line = scanner.nextLine().trim().toLowerCase();
        while (line.isEmpty() || !Character.isLetter(line.charAt(0))) {
            System.out.print("Invalid input. Try again: ");
            line = scanner.nextLine().trim().toLowerCase();
        }
        return line.charAt(0);
    }

    // EFFECTS: prompts users to view the list of words added in the list
    public void displayWordsMenu() {
        List<String> words = wordList.getWordList();

        if (words.isEmpty()) {
            System.out.println("No words have been added yet.");
            return;
        }
        System.out.println("Words in the list:");
        for (String word : words) {
            System.out.println("- " + word);
        }
    }

    // EFFECTS: displays the outcome result of winning the game
    public void displayEndGame(boolean win, String word) {
        if (win) {
            System.out.println("\nCongratulations! You've guessed the word: " + word);
        } else {
            System.out.println("\nGame over! The correct word was: " + word);
        }
    }

}
