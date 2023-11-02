package local.ytk.g.platformer1.util;

import java.util.function.Consumer;
import java.util.function.Function;

@FunctionalInterface
public interface Modifier<T> extends Consumer<T>, Function<T, T> {
    @Override
    public default T apply(T arg) {
        accept(arg);
        return arg;
    }
}
