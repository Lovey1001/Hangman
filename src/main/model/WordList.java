package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

// Citation: Got some help from JsonSerializationDemo file

// Represents a wordlist having a collection of words inputted
public class WordList implements Writable {

    private final Set<String> words;
    private final Random random = new Random();

    // EFFECTS: creates instance of this class with empty list.
    public WordList() {
        words = new HashSet<>();
    }

    // REQUIRES: words cannot be repeated in the list.
    // EFFECTS: adds the word to the list.
    public boolean addWordToList(String word) {
        return words.add(word.toLowerCase());
    }

    // EFFECTS: checks if the word is already in the list
    public boolean containsWordInList(String word) {
        return words.contains(word.toLowerCase());
    }

    // EFFECTS: selects a random word from the list
    public String getRandomWordSelected() {
        if (words.isEmpty()) {
            return null;
        }
        List<String> wordList = new ArrayList<>(words);
        return wordList.get(random.nextInt(wordList.size()));
    }

    // EFFECTS: returns a list of inputted words
    public List<String> getWordList() {
        return new ArrayList<>(words);
    }

    @Override
    public JSONObject toJson() {
        JSONArray wordsArray = new JSONArray();
        for (String word : words) {
            wordsArray.put(word);
        }
        JSONObject json = new JSONObject();
        json.put("wordsAdded", wordsArray);
        return json;
    }
}
