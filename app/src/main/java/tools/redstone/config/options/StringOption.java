package tools.redstone.config.options;

import tools.redstone.config.IOption;
import tools.redstone.config.ISerializer;
import tools.redstone.config.Option;
import tools.redstone.config.serializers.StringSerializer;

public class StringOption implements IOption<String> {
    private final StringSerializer serializer;

    @Override
    public ISerializer<String> getSerializer() {
        return serializer;
    }

    public StringOption() {
        this.serializer = new StringSerializer();
    }

    @Override
    public void render(Option<String> option) {
        throw new UnsupportedOperationException("Unimplemented method 'render'");
    }

}
