package ui;

import model.WordList;

public class Main {

    public static void main(String[] args) {
        WordList wordList = new WordList();
        HangmanGame hangmanGame = new HangmanGame(wordList);
        hangmanGame.startGame();
    }
}
