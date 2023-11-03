package tools.redstone.config;

import java.util.HashMap;

import javax.annotation.Nullable;

public class Config {
    private static Config INSTANCE;
    private final HashMap<String, String> data;

    private Config() {
        data = new HashMap<String, String>();
        loadConfig();
    }

    private void loadConfig() {
        // Would load from a file into the hashmap
        data.put("superLongButAwesomeOption", "true");
        data.put("intOption", "100");
        data.put("optionWithDisplayName", "Look ma! I have a display name");
    }

    public void saveConfig() {
        // Would update the file with the current contents of the hasmap
    }

    private static Config getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Config();
        }

        return INSTANCE;
    }

    @Nullable
    public static String getOption(String key) {
        var config = getInstance();
        return config.data.get(key);
    }

    public static void setOption(String key, String value) {
        var config = getInstance();
        config.data.put(key, value);
    }
}
