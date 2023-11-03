package tools.redstone.config;

import javax.annotation.Nullable;

public class Option<T> {
    public static <T> Option<T> ofType(IOption<T> type) {
        return new Option<>(type);
    }

    private final IOption<T> type;
    private String key;
    private String displayName;

    private T defaultValue;

    private Option(IOption<T> type) {
        this.type = type;
    }

    public Option<T> withKey(String key) {
        this.key = key;
        return this;
    }

    public Option<T> withDisplay(String display) {
        displayName = display;
        return this;
    }

    public Option<T> withDefault(T defaultValue) {
        this.defaultValue = defaultValue;
        return this;
    }

    @Nullable
    public T getValue() {
        var string = Config.getOption(key);

        if (defaultValue != null && string == null) {
            return defaultValue;
        }

        if (string == null) {
            return null;
        }

        return type.getSerializer().deserialize(string);
    }

    public String getKey() {
        return key;
    }

    public String getDisplayName() {
        return displayName;
    }

    public T getDefault() {
        return defaultValue;
    }

    public void render() {
        type.render(this);
    }

    public ISerializer<T> getSerializer() {
        return type.getSerializer();
    }

    public Option<T> ensureNamed(String fieldName) {
        if (key == null) {
            key = fieldName;
        }

        if (displayName == null) {
            displayName = key;
        }

        return this;

    }

}
