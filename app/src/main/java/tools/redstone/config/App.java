package tools.redstone.config;

import tools.redstone.config.features.TestFeature;
import tools.redstone.config.format.ConfigSection;
import tools.redstone.config.serializers.StringSerializer;

public class App {

    public static void main(String[] args) {
        var conf = ConfigSection.fromString("""
                person {
                    name {
                        first = "John"
                        last = "Doe"
                    }
                    age = 26
                }
                
            """);

        System.out.println(conf.getSection("person").orElseThrow()
                .getSection("name").orElseThrow()
                .getValue("first", new StringSerializer()).orElseThrow());

        conf.getSection("person").orElseThrow()
                .getSection("name").orElseThrow()
                .setValue("first", "Jane", new StringSerializer());

        System.out.println(conf.getSection("person").orElseThrow()
                .getSection("name").orElseThrow()
                .getValue("first", new StringSerializer()).orElseThrow());

        ///

        conf = ConfigSection.fromString("""
                testfeature { 
                   
                   superLongButAwesomeOption = true
                   intOption    =  99  
                   
                   
                   undefinedOptionWithNoDefault =true   
                   
                   optionWithDisplayName =  "some string" 
                }
                
                """);

        var test = new TestFeature();
        test.register(conf.getSection("testfeature"));
        test.execute();
    }
}
