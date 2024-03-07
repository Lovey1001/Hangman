package persistence;

import model.WordList;
import model.Hangman;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// CITATION: recieved some help from the JsonReaderTest class from JsonSerializationDemo

public class JsonReaderTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Hangman hg = reader.read();
            WordList wl = reader.readWordList();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyGame() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyGame.json");
        try {
            Hangman hg = reader.read();
            WordList wl = reader.readWordList();
            assertEquals("hangman", hg.getWord());
            assertEquals(0, wl.getWordList().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralGame() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralGame.json");
        try {
            Hangman hg = reader.read();
            WordList wl = reader.readWordList();
            assertEquals("hangman", hg.getWord());
            List<String> words = wl.getWordList();
            assertEquals(3, words.size());
            assertEquals("play", words.get(0));
            assertEquals("again", words.get(1));
            assertEquals("this", words.get(2));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}


