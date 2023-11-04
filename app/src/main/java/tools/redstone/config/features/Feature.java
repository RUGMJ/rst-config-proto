package tools.redstone.config.features;

import tools.redstone.config.ReflectionUtils;
import tools.redstone.config.format.IConfigSection;

import java.util.Optional;

public class Feature {
    // TODO: Registering and loading options should probably be moved somewhere
    //  else, as it's not something that the feature should be concerned with.
    public void register(Optional<IConfigSection> config) {
        ReflectionUtils.registerOptions(getClass());
        ReflectionUtils.loadOptions(getClass(), config);
    }

    public void execute() {

    }
}
