package persistence;

import model.Hangman;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import model.WordList;
import org.json.*;


// Citation: Got some help from JsonSerializationDemo file

// Represents a reader that reads hangmanGame from JSON data stored in file
public class JsonReader {

    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads hangman from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Hangman read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseHangman(jsonObject);
    }

    // EFFECTS: reads wordlist from file and returns it;
    // throws IOException if an error occurs reading data from file
    public WordList readWordList() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseWordList(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: Parses Hangman game state from JSON object and returns it
    private Hangman parseHangman(JSONObject jsonObject) {
        String word = jsonObject.getString("word");
        int livesLeft = jsonObject.getInt("livesLeft");
        Hangman hangman = new Hangman(word);
        hangman.setLivesLeft(livesLeft);
        addGuessedLetters(hangman, jsonObject);
        return hangman;
    }

    // MODIFIES: hangman
    // EFFECTS: parses guessed letters from JSON object and adds them to Hangman
    private void addGuessedLetters(Hangman hangman, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("guessedLetters");
        for (Object json : jsonArray) {
            String letter = (String) json;
            hangman.guessNextLetter(letter.charAt(0));
        }
    }

    // EFFECTS: parses words from JSON object and returns a WordList
    private WordList parseWordList(JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("Words Added");
        WordList wordList = new WordList();
        for (Object json : jsonArray) {
            String word = (String) json;
            wordList.addWordToList(word);
        }
        return wordList;
    }
}
