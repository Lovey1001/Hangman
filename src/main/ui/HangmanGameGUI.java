package ui;

import model.Hangman;
import model.WordList;
import java.util.List;
import java.util.Scanner;
import persistence.JsonReader;
import persistence.JsonWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;


//  Hangman Game application in Console.
// Used the TellerApp application for some code functions.
public class HangmanGameGUI extends JFrame {

    private static final String JSON_STORE = "./data/hangman.json";
    private final Scanner scanner = new Scanner(System.in);
    private WordList wordList;
    private Hangman hangmanGame;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private JFrame frame;
    private JTextField wordTextField;
    private JTextArea wordListArea;
    private JButton addButton;
    private JButton viewButton;
    private JButton saveButton;
    private JButton loadButton;
    private JButton guessButton;
    private JTextField guessTextField;
    private JLabel currentWordLabel;
    private JLabel attemptsLabel;
    private JLabel guessedLettersLabel;
    private JLabel wordToGuessLabel;
    private JLabel attemptsLeftLabel;
    private JButton startGameButton;

    // EFFECTS: runs the hangman game
    public HangmanGameGUI(WordList wordList) throws FileNotFoundException {
        // TODO
    }

    // EFFECTS: used to prepare the game field
    private void initializeGame() {
        // TODO
    }

    // EFFECTS: used to prepare the components used in the gane
    public void initializeComponents() {
        // TODO
    }

    // EFFECTS: gameplay panel used for guessing letters
    private void setupGameplayComponents() {
        // TODO
    }

    // EFFECTS: determines if game will be ready to be played or not after adding words to list
    private void setGameplayEnabled(boolean enabled) {
        // TODO
    }

    // EFFECTS: displays the current game state after word is selected at random
    private void updateGameDisplay() {
        // TODO
    }

    // EFFECTS: sets the panel for the top-portion of the GUI
    private JPanel setupTopPanel() {
        // TODO
        return null;
    }

    // EFFECTS: sets the panel for the center-portion of the GUI
    private JPanel setupCenterPanel() {
        // TODO
        return null;
    }

    // EFFECTS: sets the panel for the bottom-portion of the GUI
    private JPanel setupBottomPanel() {
        // TODO
        return null;
    }

    // EFFECTS: sets the game panel
    private JPanel setupGamePanel() {
        // TODO
        return null;
    }

    // EFFECTS: starts a new game or resets the game state
    private void startNewGame() {
        // TODO
    }

    // EFFECTS: this will determine what will happen when "Start New Game" button is pressed
    private class StartGameListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // TODO
        }
    }

    // EFFECTS: this will determine what will happen when "guess" button is pressed
    private class GuessLetterListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // TODO
        }
    }

    // EFFECTS: this will determine what will happen when "Add Word" button is pressed
    private class AddWordListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // TODO
        }
    }

    // EFFECTS: this will determine what will happen when "View Words" button is pressed
    private class ViewWordsListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // TODO
        }
    }

    // EFFECTS: this will determine what will happen when "Save Game" button is pressed
    private class SaveGameListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // TODO
        }
    }

    // EFFECTS: this will determine what will happen when "Load Game" button is pressed
    private class LoadGameListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // TODO
        }
    }
}