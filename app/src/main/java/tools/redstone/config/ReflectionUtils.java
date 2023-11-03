package tools.redstone.config;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ReflectionUtils {
    public static void registerOptions(Class<?> featureClass) {
        Arrays.stream(featureClass.getFields()).filter(field -> Option.class.isAssignableFrom(field.getType()))
                .map(field -> {
                    var modifiers = field.getModifiers();
                    if (!Modifier.isPublic(modifiers) || !Modifier.isStatic(modifiers)
                            || !Modifier.isFinal(modifiers)) {
                        throw new RuntimeException("Field " + field.getName() + " of feature " + featureClass.getName()
                                + " is not public static final");
                    }

                    try {
                        var option = (Option<?>) field.get(null);

                        return option.ensureNamed(field.getName());
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException("Failed to get value of field " + field.getName(), e);
                    }
                }).collect(Collectors.toList());
    }
}
