package persistence;

import model.WordList;
import model.Hangman;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// CITATION: recieved some help from the JsonWriterTest class from JsonSerializationDemo

public class JsonWriterTest {

    @Test
    void testWriterInvalidFile() {
        try {
            Hangman hg = new Hangman("hangman");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyGame() {
        try {
            Hangman hg = new Hangman("hangman");
            WordList wl = new WordList();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyGame.json");
            writer.open();
            writer.write(hg, wl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyGame.json");
            hg = reader.read();
            wl = reader.readWordList();
            assertEquals("hangman", hg.getWord());
            assertEquals(0, wl.getWordList().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
//
    @Test
    void testWriterGeneralGame() {
        try {
            Hangman hg = new Hangman("hangman");
            WordList wl = new WordList();
            wl.addWordToList("new");
            wl.addWordToList("words");
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralGame.json");
            writer.open();
            writer.write(hg, wl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralGame.json");
            hg = reader.read();
            wl = reader.readWordList();
            assertEquals("hangman", hg.getWord());
            List<String> words = wl.getWordList();
            assertEquals(2, words.size());
            assertEquals("new", words.get(0));
            assertEquals("words", words.get(1));
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
