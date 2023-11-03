package tools.redstone.config.features;

import tools.redstone.config.ReflectionUtils;

public class Feature {
    public void register() {
        ReflectionUtils.registerOptions(getClass());
    }

    public void execute() {

    }
}
