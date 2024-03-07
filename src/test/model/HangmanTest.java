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
        assertEquals("Computer", game1.getWord());
        assertEquals(6, game1.getLivesLeft());
        assertTrue(game1.getGuessedLetters().isEmpty());
    }

    @Test
    public void guessNextLetterCorrectTest() {
        game1.guessNextLetter('p');
        assertEquals(6, game1.getLivesLeft());
        assertTrue(game1.getGuessedLetters().contains('p'));
        assertEquals(1, game1.getGuessedLetters().size());
    }

    @Test
    public void guessNextLetterIncorrectTest() {
        game1.guessNextLetter('q');
        assertEquals(5, game1.getLivesLeft());
        assertTrue(game1.getGuessedLetters().contains('q'));
        assertEquals(1, game1.getGuessedLetters().size());
    }

    @Test
    public void guessNext2LettersCorrectTest() {
        game1.guessNextLetter('p');
        assertEquals(6, game1.getLivesLeft());
        assertTrue(game1.getGuessedLetters().contains('p'));
        assertEquals(1, game1.getGuessedLetters().size());

        game1.guessNextLetter('o');
        assertEquals(6, game1.getLivesLeft());
        assertTrue(game1.getGuessedLetters().contains('o'));
        assertEquals(2, game1.getGuessedLetters().size());
    }

    @Test
    public void guessNext2LettersIncorrectTest() {
        game1.guessNextLetter('q');
        assertEquals(5, game1.getLivesLeft());
        assertTrue(game1.getGuessedLetters().contains('q'));
        assertEquals(1, game1.getGuessedLetters().size());

        game1.guessNextLetter('z');
        assertEquals(4, game1.getLivesLeft());
        assertTrue(game1.getGuessedLetters().contains('z'));
        assertEquals(2, game1.getGuessedLetters().size());
    }

    @Test
    public void guessNextLetterRepeatedTest() {
        game1.guessNextLetter('C');
        assertEquals(6, game1.getLivesLeft());
        assertTrue(game1.getGuessedLetters().contains('C'));
        assertEquals(1, game1.getGuessedLetters().size());

        assertTrue(game1.guessNextLetter('C'));
        assertEquals(6, game1.getLivesLeft());
        assertTrue(game1.getGuessedLetters().contains('C'));
        assertEquals(1, game1.getGuessedLetters().size());
    }

    @Test
    public void wordGuessedCompletelyTest() {
        game1.guessNextLetter('C');
        game1.guessNextLetter('o');
        game1.guessNextLetter('m');
        game1.guessNextLetter('p');
        game1.guessNextLetter('u');
        game1.guessNextLetter('t');
        game1.guessNextLetter('e');
        game1.guessNextLetter('r');
        assertTrue(game1.wordGuessed());
    }

    @Test
    public void wordGuessedPartiallyTest() {
        game1.guessNextLetter('t');
        game1.guessNextLetter('o');
        game1.guessNextLetter('C');
        game1.guessNextLetter('p');
        game1.guessNextLetter('u');
        assertFalse(game1.wordGuessed());
    }

    @Test
    public void getWordWithGuessesContainsLetterTest() {
        game1.guessNextLetter('p');
        assertEquals("_ _ _ p _ _ _ _", game1.getWordWithGuesses());
    }

    @Test
    public void getWordWithGuessesNotContainsLetterTest() {
        game1.guessNextLetter('l');
        assertEquals("_ _ _ _ _ _ _ _", game1.getWordWithGuesses());
    }

    @Test
    public void getWordWithGuessesContainsMultipleLetterTest() {
        game1.guessNextLetter('p');
        game1.guessNextLetter('C');
        game1.guessNextLetter('r');
        assertEquals("C _ _ p _ _ _ r", game1.getWordWithGuesses());
    }

    @Test
    public void getWordWithGuessesNotContainsMultipleLetterTest() {
        game1.guessNextLetter('l');
        game1.guessNextLetter('i');
        assertEquals("_ _ _ _ _ _ _ _", game1.getWordWithGuesses());
    }

    @Test
    public void isGameOverTrueByWordGuessedTest() {
        game1.guessNextLetter('C');
        game1.guessNextLetter('o');
        game1.guessNextLetter('m');
        game1.guessNextLetter('p');
        game1.guessNextLetter('u');
        game1.guessNextLetter('t');
        game1.guessNextLetter('e');
        game1.guessNextLetter('r');
        assertTrue(game1.isGameOver());
    }

    @Test
    public void isGameOverTrueByAllLivesLostTest() {
        game1.guessNextLetter('a');
        game1.guessNextLetter('b');
        game1.guessNextLetter('d');
        game1.guessNextLetter('f');
        game1.guessNextLetter('g');
        game1.guessNextLetter('h');
        game1.guessNextLetter('l');
        assertTrue(game1.isGameOver());
    }

    @Test
    public void isGameOverFalseTest() {
        game1.guessNextLetter('a');
        game1.guessNextLetter('C');
        game1.guessNextLetter('p');
        game1.guessNextLetter('f');
        game1.guessNextLetter('r');
        game1.guessNextLetter('l');
        assertFalse(game1.isGameOver());
        assertEquals(3,game1.getLivesLeft());
        assertEquals(6,game1.getGuessedLetters().size());
        assertEquals("C _ _ p _ _ _ r", game1.getWordWithGuesses());
    }
}