package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WordListTest {

    private WordList wordList;

    @BeforeEach
    public void setUp() {
        wordList = new WordList();
    }

    @Test
    public void testConstructor() {
        assertEquals(0, wordList.getWordList().size());
    }

    @Test
    public void addSingleWordToListTest() {

    }

    @Test
    public void addMultipleWordsToListTest() {

    }

    @Test
    public void addDuplicateWordsToListTest() {

    }

    @Test
    public void addNonStringWordsToListTest() {

    }

    @Test
    public void containsWordInListTest() {

    }

    @Test
    public void didNotContainWordInListTest() {

    }

    @Test
    public void getRandomWordSelectedWithSingleWordTest() {

    }

    @Test
    public void getRandomWordSelectedFromMultipleWordsTest() {

    }

    @Test
    public void getRandomWordSelectedWithEmptyListTest() {

    }

    @Test
    public void getWordListTest() {

    }








}
