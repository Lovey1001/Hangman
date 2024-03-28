package ui;

import model.Hangman;
import model.WordList;
import persistence.JsonReader;
import persistence.JsonWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//  Hangman Game application in GUI.
// Used the TellerApp application for some code functions.
// Used the GUIToolsSolution for some code considerations
public class HangmanGameGUI extends JFrame {

    private static final String JSON_STORE = "./data/hangman.json";
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
        this.wordList = wordList;
        initializeComponents();
        initializeGame();
        startNewGame();
    }

    // EFFECTS: used to prepare the game field
    private void initializeGame() {
        setupGameplayComponents();
    }

    // EFFECTS: used to prepare the components used in the game
    public void initializeComponents() {
        frame = new JFrame("Hangman Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        wordList = new WordList();
        hangmanGame = new Hangman("Hangman");
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        frame.add(setupTopPanel(), BorderLayout.NORTH);
        frame.add(setupCenterPanel(), BorderLayout.CENTER);
        frame.add(setupBottomPanel(), BorderLayout.SOUTH);
        frame.add(setupGamePanel(), BorderLayout.EAST);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // EFFECTS: gameplay panel used for guessing letters
    private void setupGameplayComponents() {
        JPanel gameplayPanel = new JPanel(new GridLayout(0, 1, 5, 5));
        gameplayPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        startGameButton = new JButton("Start New Game");
        startGameButton.addActionListener(new StartGameListener());
        gameplayPanel.add(startGameButton);

        wordToGuessLabel = new JLabel("Current word: ");
        gameplayPanel.add(wordToGuessLabel);

        attemptsLeftLabel = new JLabel("Attempts left: ");
        gameplayPanel.add(attemptsLeftLabel);

        guessedLettersLabel = new JLabel("Guessed letters: ");
        gameplayPanel.add(guessedLettersLabel);

        guessTextField = new JTextField();
        gameplayPanel.add(guessTextField);

        guessButton = new JButton("Guess");
        guessButton.addActionListener(new GuessLetterListener());
        gameplayPanel.add(guessButton);

        setGameplayEnabled(false);
        frame.add(gameplayPanel, BorderLayout.EAST);

        frame.pack();
    }

    // EFFECTS: determines if game will be ready to be played or not after adding words to list
    private void setGameplayEnabled(boolean enabled) {
        guessTextField.setEnabled(enabled);
        guessButton.setEnabled(enabled);
        if (!enabled) {
            wordToGuessLabel.setText("Current word: ");
            attemptsLeftLabel.setText("Attempts left: ");
            guessedLettersLabel.setText("Guessed letters: ");
        }
    }

    // EFFECTS: displays the current game state after word is selected at random
    private void updateGameDisplay() {
        wordToGuessLabel.setText("Current word: " + hangmanGame.getWordWithGuesses());
        attemptsLeftLabel.setText("Attempts left: " + hangmanGame.getLivesLeft());
        guessedLettersLabel.setText("Guessed letters: " + hangmanGame.getGuessedLetters());
    }

    // EFFECTS: sets the panel for the top-portion of the GUI
    private JPanel setupTopPanel() {
        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(new JLabel("Enter a word:"));
        topPanel.add(wordTextField = new JTextField(20));
        topPanel.add(addButton = new JButton("Add Word"));
        addButton.addActionListener(new AddWordListener());
        return topPanel;
    }

    // EFFECTS: sets the panel for the center-portion of the GUI
    private JPanel setupCenterPanel() {
        JPanel centerPanel = new JPanel(new BorderLayout());
        wordListArea = new JTextArea(20, 30);
        wordListArea.setEditable(false);
        centerPanel.add(new JScrollPane(wordListArea), BorderLayout.CENTER);
        return centerPanel;
    }

    // EFFECTS: sets the panel for the bottom-portion of the GUI
    private JPanel setupBottomPanel() {
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(viewButton = new JButton("View Words"));
        bottomPanel.add(saveButton = new JButton("Save Game"));
        bottomPanel.add(loadButton = new JButton("Load Game"));
        viewButton.addActionListener(new ViewWordsListener());
        saveButton.addActionListener(new SaveGameListener());
        loadButton.addActionListener(new LoadGameListener());
        return bottomPanel;
    }

    // EFFECTS: sets the game panel
    private JPanel setupGamePanel() {
        JPanel gamePanel = new JPanel(new GridLayout(4, 1));
        gamePanel.add(currentWordLabel = new JLabel("Current word: "));
        gamePanel.add(attemptsLabel = new JLabel("Attempts left: "));
        gamePanel.add(guessedLettersLabel = new JLabel("Guessed letters: "));

        JPanel guessPanel = new JPanel();
        guessPanel.add(new JLabel("Enter your guess: "));
        guessPanel.add(guessTextField = new JTextField(4));
        gamePanel.add(guessPanel);
        return gamePanel;
    }

    // EFFECTS: starts a new game or resets the game state
    private void startNewGame() {
        String wordToGuess = wordList.getRandomWordSelected();
        if (wordToGuess == null) {
            JOptionPane.showMessageDialog(frame, "No Words added yet. Add a word!");
            return;
        }
        hangmanGame = new Hangman(wordToGuess);
        updateGameDisplay();
    }

    // EFFECTS: this will determine what will happen when "Start New Game" button is pressed
    private class StartGameListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String wordToGuess = wordList.getRandomWordSelected();
            if (wordToGuess == null) {
                JOptionPane.showMessageDialog(frame,
                        "All words have been used or no words available. Game over.");
                return;
            }
            hangmanGame = new Hangman(wordToGuess);
            updateGameDisplay();
            setGameplayEnabled(true);
        }
    }

    // EFFECTS: this will determine what will happen when "guess" button is pressed
    private class GuessLetterListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String guessStr = guessTextField.getText().trim().toLowerCase();
            if (!guessStr.isEmpty() && Character.isLetter(guessStr.charAt(0))) {
                hangmanGame.guessNextLetter(guessStr.charAt(0));
                updateGameDisplay();
                guessTextField.setText("");

                if (hangmanGame.isGameOver()) {
                    setGameplayEnabled(false);
                    ImageIcon image = new ImageIcon("./data/win.jpeg");
                    if (hangmanGame.wordGuessed()) {
                        JOptionPane.showMessageDialog(frame, "Congratulations! You've guessed the word!",
                                "You Win!", JOptionPane.INFORMATION_MESSAGE, image);
                    } else {
                        String message = "Game over! The correct word was: " + hangmanGame.getWord();
                        JOptionPane.showMessageDialog(frame, message);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid guess. Please enter a single letter.");
            }
        }
    }

    // EFFECTS: this will determine what will happen when "Add Word" button is pressed
    private class AddWordListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String word = wordTextField.getText().trim();
            if (!word.isEmpty() && word.matches("^[a-zA-Z]+$")) {
                if (wordList.containsWordInList(word)) {
                    JOptionPane.showMessageDialog(frame, "This word already exists.");
                } else {
                    wordList.addWordToList(word);
                    JOptionPane.showMessageDialog(frame, "Word added.");
                    wordTextField.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Please add an appropriate word.");
            }
        }
    }

    // EFFECTS: this will determine what will happen when "View Words" button is pressed
    private class ViewWordsListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            StringBuilder wordsBuilder = new StringBuilder();
            for (String word : wordList.getWordList()) {
                wordsBuilder.append(word).append("\n");
            }
            wordListArea.setText(wordsBuilder.toString());
            Timer timer = new Timer(3000, event -> wordListArea.setText(""));
            timer.start();
        }
    }

    // EFFECTS: this will determine what will happen when "Save Game" button is pressed
    private class SaveGameListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                jsonWriter.open();
                jsonWriter.write(hangmanGame, wordList);
                jsonWriter.close();
                JOptionPane.showMessageDialog(frame, "Game saved to " + JSON_STORE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Unable to save game: " + ex.getMessage());
            }
        }
    }

    // EFFECTS: this will determine what will happen when "Load Game" button is pressed
    private class LoadGameListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                hangmanGame = jsonReader.read();
                wordList = jsonReader.readWordList();
                JOptionPane.showMessageDialog(frame, "Game loaded from " + JSON_STORE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Unable to load game: " + ex.getMessage());
            }
        }
    }
}