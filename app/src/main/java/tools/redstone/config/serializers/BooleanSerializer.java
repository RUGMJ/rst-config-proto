package tools.redstone.config.serializers;

import java.util.ArrayList;
import java.util.List;

import tools.redstone.config.ISerializer;
import tools.redstone.config.SuggestionContext;

public class BooleanSerializer implements ISerializer<Boolean> {
    public BooleanSerializer() {
    }

    @Override
    public String serialize(Boolean value) {
        return value.toString();
    }

    @Override
    public Boolean deserialize(String string) {
        return string.equals("true");
    }

    @Override
    public List<String> getSuggestions(SuggestionContext context, String string) {
        final var completions = new ArrayList<String>();
        completions.add("false");
        completions.add("true");
        return completions;
    }
}
