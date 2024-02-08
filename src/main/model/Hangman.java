package model;

// Represents a traditional hangman game, where a user can input a word into a empty list of words
// and have to guess the random word picked from the list, letter by letter. You can look at the list of words
// guessed as well as see the number of wins/losses that the user has made.

import java.util.Set;

public class Hangman {

    private String word;

    // REQUIRES: string > 0
    // MODIFIES: this
    // EFFECTS: displays the word guessed
    public Hangman(String word) {
        //TODO
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS:
    public boolean guessNextLetter(char letter) {
        //TODO
        return false;
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS:
    public boolean wordGuessed() {
        // TODO
        return false;
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS:
    public String getWordWithGuesses() {
        // TODO
        return "";
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS:
    public Set<Character> getGuessedLetters() {
        // TODO
        return null;
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS:
    public int numberOfLivesLeft() {
        // TODO
        return 0;
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS:
    public boolean isGameOver() {
        // TODO
        return true;
    }
}
