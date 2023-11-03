package tools.redstone.config.serializers;

import java.util.ArrayList;
import java.util.List;

import tools.redstone.config.ISerializer;
import tools.redstone.config.SuggestionContext;

public class StringSerializer implements ISerializer<String> {

    @Override
    public String serialize(String value) {
        return value;
    }

    @Override
    public String deserialize(String string) {
        return string;
    }

    @Override
    public List<String> getSuggestions(SuggestionContext context, String string) {
        return new ArrayList<>();
    }

}
