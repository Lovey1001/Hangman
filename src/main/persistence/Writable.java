package persistence;

import org.json.JSONObject;

// Citation: Got some help from JsonSerializationDemo file from CPSC 210
public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
