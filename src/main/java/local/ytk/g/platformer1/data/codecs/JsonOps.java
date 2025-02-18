package local.ytk.g.platformer1.data.codecs;

import com.google.gson.*;
import local.ytk.util.json.JsonUtils;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public class JsonOps implements Ops<JsonElement> {
    @Override
    public Object getObject(JsonElement element) {
        return JsonUtils.getAsObject(element);
    }
    @Override
    public <U> U convert(JsonElement element, Ops<U> outOps) {
        return null;
    }
    @Override
    public JsonElement ofEmpty() {
        return JsonNull.INSTANCE;
    }
    @Override
    public JsonElement ofNumber(Number n) {
        return new JsonPrimitive(n);
    }
    @Override
    public JsonElement ofString(String s) {
        return new JsonPrimitive(s);
    }
    @Override
    public JsonElement ofChar(char c) {
        return new JsonPrimitive(c);
    }
    @Override
    public JsonElement ofBool(boolean b) {
        return new JsonPrimitive(b);
    }
    @Override
    public Number getNumber(JsonElement element) {
        return element instanceof JsonPrimitive p && p.isNumber() ? p.getAsNumber() : 0d;
    }
    @Override
    public String getString(JsonElement element) {
        return element instanceof JsonPrimitive ? element.getAsString() : element.toString();
    }
    @Override
    public char getChar(JsonElement element) {
        return element instanceof JsonPrimitive ? element.getAsCharacter() : '\0';
    }
    @Override
    public boolean getBool(JsonElement element) {
        if (element.isJsonNull()) return false;
        if (element instanceof JsonPrimitive p)
            if (p.isNumber() && p.getAsNumber().doubleValue() == 0d) return false;
            else if (p.isBoolean() && !p.getAsBoolean()) return false;
            else if (Objects.equals(p.getAsString(), "")) return false;
        return !(element.isJsonArray() && element.getAsJsonArray().size() == 0);
    }
    @Override
    public JsonElement ofStream() {
        return ofList();
    }
    @Override
    public <E extends JsonElement> JsonElement ofStream(E item) {
        return ofList(item);
    }
    @Override
    public <E extends JsonElement> JsonElement ofStream(Stream<E> s) {
        return ofList(s.toList());
    }
    @Override
    public <E extends JsonElement> JsonElement mergeStream(JsonElement stream, E item) {
        return null;
    }
    @Override
    public <E extends JsonElement> JsonElement mergeStreams(JsonElement stream, Stream<E> items) {
        return null;
    }
    @Override
    public JsonElement mergeStreams(JsonElement stream1, JsonElement stream2) {
        return null;
    }
    @Override
    public <E> Stream<E> getStream(JsonElement element) {
        return null;
    }
    @Override
    public JsonElement ofList() {
        return new JsonArray();
    }
    @Override
    public <E extends JsonElement> JsonElement ofList(E item) {
        JsonArray array = new JsonArray();
        array.add(item);
        return array;
    }
    @Override
    public <E extends JsonElement> JsonElement ofList(Collection<E> l) {
        JsonArray array = new JsonArray();
        l.forEach(array::add);
        return array;
    }
    @Override
    public <E extends JsonElement> JsonElement mergeList(JsonElement list, E item) {
        return null;
    }
    @Override
    public <E extends JsonElement> JsonElement mergeLists(JsonElement list, List<E> items) {
        return null;
    }
    @Override
    public JsonElement mergeLists(JsonElement list1, JsonElement list2) {
        return null;
    }
    @Override
    public <E extends JsonElement> E add(JsonElement list) {
        return null;
    }
    @Override
    public <E extends JsonElement> E add(JsonElement list, int index) {
        return null;
    }
    @Override
    public <E extends JsonElement> E set(JsonElement list, int index, E value) {
        return null;
    }
    @Override
    public <E extends JsonElement> E get(JsonElement list, int index) {
        return null;
    }
    @Override
    public <E extends JsonElement> E remove(JsonElement list, int index) {
        return null;
    }
    @Override
    public <E> List<E> getList(JsonElement element) {
        return null;
    }
    @Override
    public JsonElement ofMap() {
        return null;
    }
    @Override
    public <K extends JsonElement, V extends JsonElement> JsonElement toMap(K k, V v) {
        return null;
    }
    @Override
    public <K extends JsonElement, V extends JsonElement> JsonElement ofMap(Map<K, V> m) {
        return null;
    }
    @Override
    public <K extends JsonElement, V extends JsonElement> JsonElement mergeMap(JsonElement map, K k, V v) {
        return null;
    }
    @Override
    public <K extends JsonElement, V extends JsonElement> JsonElement mergeMap(JsonElement map, Map<K, V> items) {
        return null;
    }
    @Override
    public JsonElement mergeMaps(JsonElement map1, JsonElement map2) {
        return null;
    }
    @Override
    public <K extends JsonElement, V extends JsonElement> V set(JsonElement map, K k, V v) {
        return null;
    }
    @Override
    public <K extends JsonElement, V extends JsonElement> V get(JsonElement map, K k) {
        return null;
    }
    @Override
    public <K extends JsonElement, V extends JsonElement> V remove(JsonElement map, K k) {
        return null;
    }
    @Override
    public <K, V> Map<K, V> getMap(JsonElement element) {
        return null;
    }
}
