package tools.redstone.config.options;

import tools.redstone.config.IOption;
import tools.redstone.config.ISerializer;
import tools.redstone.config.Option;
import tools.redstone.config.serializers.BooleanSerializer;

public class BooleanOption implements IOption<Boolean> {
    private final BooleanSerializer serializer;

    @Override
    public ISerializer<Boolean> getSerializer() {
        return serializer;
    }

    public BooleanOption() {
        this.serializer = new BooleanSerializer();
    }

    @Override
    public void render(Option<Boolean> option) {
        throw new UnsupportedOperationException("Unimplemented method 'render'");
    }

}
