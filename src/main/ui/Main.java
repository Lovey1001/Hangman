package ui;

import model.WordList;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        try {
            WordList wordList = new WordList();
            new HangmanGame(wordList);

        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }
}
