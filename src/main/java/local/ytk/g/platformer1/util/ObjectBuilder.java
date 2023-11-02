package local.ytk.g.platformer1.util;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class ObjectBuilder {
    public static <T> T build(Supplier<T> builder){
        return builder.get();
    }
    public static <T> T build(T value, Consumer<T> builder){
        builder.accept(value);
        return value;
    }
    public static <T, U> U build(T value, Function<T, U> builder){
        return builder.apply(value);
    }
}
