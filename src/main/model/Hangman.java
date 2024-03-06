package model;

import java.util.LinkedHashSet;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

// Citation: Got some help from JsonSerializationDemo file

// Represents a traditional hangman game, where a user can input a word into an empty list of words
// and have to guess the random word picked from the list, letter by letter. You can look at the list of words
// guessed as well as see the letters you already typed.
public class Hangman implements Writable {

    private final String word;
    private final Set<Character> guessedLetters = new LinkedHashSet<>();
    private int livesLeft = 6;

    // REQUIRES: string > 0 letters;
    // MODIFIES: this
    // EFFECTS: gives a word that will need to be guessed
    public Hangman(String word) {
        this.word = word;
    }

    // EFFECTS: checks if the next letter is the letter in the word, adds the letter to list of guessed letters
    public boolean guessNextLetter(char letter) {
        if (guessedLetters.contains(letter)) {
            return true;
        }
        guessedLetters.add(letter);

        if (word.indexOf(letter) >= 0) {
            return true;
        } else {
            livesLeft--;
            return false;
        }
    }

    // EFFECTS: checks if the entire word was guessed properly, otherwise returns false
    public boolean wordGuessed() {
        for (char letter : word.toCharArray()) {
            if (!guessedLetters.contains(letter)) {
                return false;
            }
        }
        return true;
    }

    // MODIFIES: this
    // EFFECTS: puts the letter into the word if guessed right, otherwise puts "_"
    public String getWordWithGuesses() {

        StringBuilder newWord = new StringBuilder();
        for (char letter : word.toCharArray()) {
            if (guessedLetters.contains(letter)) {
                newWord.append(letter);
            } else {
                newWord.append('_');
            }
            newWord.append(' ');
        }
        return newWord.toString().trim();
    }

    // EFFECTS: shows how many attempts are left
    public int numberOfLivesLeft() {
        return livesLeft;
    }

    // MODIFIES: this
    // EFFECTS: checks if game is over or not
    public boolean isGameOver() {
        return livesLeft <= 0 || wordGuessed();
    }

    // EFFECTS: returns set of letters inputted
    public Set<Character> getGuessedLetters() {
        return guessedLetters;
    }

    // MODIFIES: this
    // EFFECTS: sets the number of lives left to the given number
    public void setLivesLeft(int lives) {
        this.livesLeft = lives;
    }

    @Override
    // EFFECTS: converts Hangman object to JSON object
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("word", word);
        json.put("livesLeft", livesLeft);
        json.put("guessedLetters", guessedLetters);
        return json;
    }
}
