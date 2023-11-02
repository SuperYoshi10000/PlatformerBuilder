package local.ytk.g.platformer1.util;

import java.util.List;
import java.util.stream.Collectors;

import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.ints.IntArrayList;

public class CollectionUtils {
    public static IntArrayList indexes(List<?> list) {
        return range(list.size());
    }
    @SuppressWarnings("deprecation")
    public static <T> Int2ObjectOpenHashMap<T> toIntMap(List<T> list) {
        return new Int2ObjectOpenHashMap<T>(indexes(list).stream().collect(Collectors.toMap(i -> i, i -> list.get(i))));
    }
    
    public static IntArrayList range(int max) {
        return range(0, max, 1);
    }
    public static IntArrayList range(int min, int max) {
        return range(min, max, 1);
    }
    public static IntArrayList range(int min, int max, int count) {
        IntArrayList intList = new IntArrayList();
        for (int i = min; i < max; i += count) {
            intList.add(i);
        }
        return intList;
    }
}
