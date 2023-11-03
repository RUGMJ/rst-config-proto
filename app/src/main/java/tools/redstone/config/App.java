package tools.redstone.config;

import tools.redstone.config.features.TestFeature;

public class App {

    public static void main(String[] args) {
        var test = new TestFeature();
        test.register();
        test.execute();
    }
}
