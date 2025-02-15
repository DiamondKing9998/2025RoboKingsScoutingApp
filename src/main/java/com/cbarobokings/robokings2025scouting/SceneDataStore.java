package com.cbarobokings.robokings2025scouting;

import java.util.HashMap;
import java.util.Map;

public class SceneDataStore {
    private static final SceneDataStore instance = new SceneDataStore();
    private final Map<String, Object> data = new HashMap<>();
    private boolean isFinalized = false;  // Only commit when a button is clicked on the last page

    private SceneDataStore() {}  // Private constructor to enforce Singleton

    public static SceneDataStore getInstance() {
        return instance;
    }

    public void setValue(String key, Object value) {
        if (!isFinalized) {  // Prevent changes after finalization
            data.put(key, value);
        }
    }

    public Object getValue(String key) {
        return data.get(key);
    }

    public void clearData() {
        data.clear();
        isFinalized = false; // Allow new changes
    }

    public void finalizeData() {
        isFinalized = true;
    }
}
