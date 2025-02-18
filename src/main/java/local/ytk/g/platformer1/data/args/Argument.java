package local.ytk.g.platformer1.data.args;

import java.util.List;
import local.ytk.util.function.StringFunction;

public class Argument<T> {
    protected static final ArgTypeConverter<String> STRING = tc(String.class, a -> a);
    protected static final List<ArgTypeConverter<?>> converters = List.of(
        tc(Boolean.class, a -> Boolean.valueOf(a)),
        tc(Integer.class, a -> Integer.valueOf(a)),
        tc(Long.class, a -> Long.valueOf(a)),
        tc(Double.class, a -> Double.valueOf(a)),
        tc(Character.class, a -> Character.valueOf(a.charAt(0))),
        STRING
    );

    
    protected static <T> ArgTypeConverter<T> toNull(Class<T> type) {
        return tc(type, a -> null);
    }

    public final String content;
    public final T value;

    public Argument(String argument, StringFunction<T> converter) {
        content = argument;
        value = converter.apply(argument);
    }

    @SuppressWarnings("unchecked")
    public static <T> Argument<T> read(String argument, Class<T> type) {
        return new Argument<T>(argument, (ArgTypeConverter<T>) converters
            .stream()
            .filter(i -> i.type == type)
            .findFirst()
            .orElse(toNull(type)));
    }

    protected static <T> ArgTypeConverter<T> tc(Class<T> type, StringFunction<T> converter){
        return new ArgTypeConverter<T>(type, converter);
    }

    protected static class ArgTypeConverter<T> implements StringFunction<T> {
        protected final Class<T> type;
        protected final StringFunction<T> converter;
        public ArgTypeConverter(Class<T> type, StringFunction<T> converter) {
            this.type = type;
            this.converter = converter;
        }
        @Override
        public T apply(String a) {
            return converter.apply(a);
        }
    }
}
