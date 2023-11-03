package tools.redstone.config.features;

import tools.redstone.config.Option;
import tools.redstone.config.options.BooleanOption;
import tools.redstone.config.options.IntOption;
import tools.redstone.config.options.StringOption;

public class TestFeature extends Feature {
    public static final Option<Boolean> superLongButAwesomeOption = Option.ofType(new BooleanOption());
    public static final Option<Boolean> undefinedOption = Option.ofType(new BooleanOption()).withDefault(false);
    public static final Option<Boolean> undefinedOptionWithNoDefault = Option.ofType(new BooleanOption());
    public static final Option<Integer> intOption = Option.ofType(new IntOption(0, 100)).withDefault(69);
    public static final Option<String> optionWithDisplayName = Option.ofType(new StringOption())
            .withDisplay("Fancy Display Name");

    public void execute() {
        print_option(superLongButAwesomeOption);
        print_option(undefinedOption);
        print_option(undefinedOptionWithNoDefault);
        print_option(intOption);
        print_option(optionWithDisplayName);

        intOption.render();
    }

    private void print_option(Option<?> option) {
        System.out.println(option.getDisplayName() + " (" + option.getKey()
                + "): " + option.getValue());
    }
}
