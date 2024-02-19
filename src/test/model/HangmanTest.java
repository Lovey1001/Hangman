package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HangmanTest {

    private Hangman game1;

    @BeforeEach
    public void runBefore() {
        game1 = new Hangman("Computer");
    }

    @Test
    public void testConstructor() {
        assertEquals(6, game1.numberOfLivesLeft());
        assertTrue(game1.getGuessedLetters().isEmpty());
    }

    @Test
    public void guessNextLetterCorrectTest() {

    }

    @Test
    public void guessNextLetterIncorrectTest() {

    }

    @Test
    public void guessNext2LettersCorrectTest() {

    }

    @Test
    public void guessNext2LettersIncorrectTest() {

    }

    @Test
    public void guessNextLetterRepeatedTest() {

    }

    @Test
    public void wordGuessedCompletelyTest() {

    }

    @Test
    public void wordGuessedPartiallyTest() {

    }

    @Test
    public void getWordWithGuessesContainsLetterTest() {

    }

    @Test
    public void getWordWithGuessesNotContainsLetterTest() {

    }

    @Test
    public void isGameOverTrueTest() {

    }

    @Test
    public void isGameOverFalseTest() {

    }
}