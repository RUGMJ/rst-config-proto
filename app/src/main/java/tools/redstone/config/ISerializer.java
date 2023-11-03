package tools.redstone.config;

import java.util.List;

public interface ISerializer<T> {

    String serialize(T value);

    T deserialize(String string);

    List<String> getSuggestions(SuggestionContext context, String string);
}
