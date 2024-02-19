package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        assertTrue(wordList.addWordToList("hello"));
    }

    @Test
    public void addMultipleWordsToListTest() {
        assertTrue(wordList.addWordToList("hello"));
        assertTrue(wordList.addWordToList("king"));
        assertTrue(wordList.addWordToList("tech"));
        assertTrue(wordList.addWordToList("queen"));
    }

    @Test
    public void addDuplicateWordsToListTest() {
        assertTrue(wordList.addWordToList("hello"));
        assertTrue(wordList.addWordToList("pauper"));
        assertTrue(wordList.addWordToList("hi"));
        assertFalse(wordList.addWordToList("hello"));
    }

    @Test
    public void containsWordInListTest() {
        wordList.addWordToList("permutations");
        wordList.addWordToList("logic");
        wordList.addWordToList("math");
        assertTrue(wordList.containsWordInList("permutations"));
    }

    @Test
    public void didNotContainWordInListTest() {
        wordList.addWordToList("permutations");
        wordList.addWordToList("logic");
        wordList.addWordToList("math");
        assertFalse(wordList.containsWordInList("probability"));
    }

    @Test
    public void getRandomWordSelectedWithSingleWordTest() {
        wordList.addWordToList("logic");
        assertNotNull(wordList.getRandomWordSelected());
        assertTrue(wordList.containsWordInList(wordList.getRandomWordSelected()));
    }

    @Test
    public void getRandomWordSelectedFromMultipleWordsTest() {
        wordList.addWordToList("logic");
        wordList.addWordToList("magic");
        wordList.addWordToList("tragic");
        assertNotNull(wordList.getRandomWordSelected());
        assertTrue(wordList.containsWordInList(wordList.getRandomWordSelected()));
    }

    @Test
    public void getRandomWordSelectedWithEmptyListTest() {
        assertNull(wordList.getRandomWordSelected());
    }

    @Test
    public void getWordListTest() {
        wordList.addWordToList("science");
        wordList.addWordToList("english");
        wordList.addWordToList("math");

        List<String> words = wordList.getWordList();
        assertEquals(3, words.size());
        assertTrue(words.contains("science"));
        assertTrue(words.contains("math"));
    }

    @Test
    public void getWordListEmptyListTest() {
        List<String> words = wordList.getWordList();
        assertEquals(0, words.size());
        assertFalse(words.contains("physics"));
    }








}
