package local.ytk.g.platformer1.util;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public interface SequentialCollector<T, A> extends Collector<T, A, A> {
    public static <T, A> SequentialCollector<T, A> create(Supplier<A> supplier, BiConsumer<A, T> accumulator) {
        return new SequentialCollector<T, A>() {
            @Override
            public Supplier<A> supplier() {
                return supplier;
            }
            @Override
            public BiConsumer<A, T> accumulator() {
                return accumulator;
            }
        };
    }

    @Override
    public default BinaryOperator<A> combiner() {
        return (a, b) -> a;
    }

    @Override
    public default Function<A, A> finisher() {
        return a -> a;
    }

    @Override
    public default Set<Characteristics> characteristics() {
        return Set.of();
    }
    
}
