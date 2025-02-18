package local.ytk.g.platformer1.data.tag;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public record RepeatedTag<T extends Tag<T, T>, S extends RepeatedTag<T, S>>(T tag, int count) implements SequenceTag<T, T, S> {
    @Override
    public byte getId() {
        return 9;
    }
    
    @Override
    public Object objectValue() {
        return null;
    }
    
    @Override
    public byte getItemId() {
        return tag.getId();
    }
    @Override
    public String toTagString() {
        if (count == 0) return "[]";
        return "[" + tag.toTagString() + "]";
    }
    
    @Override
    public List<T> toTagList() {
        return List.of();
    }
    
    @Override
    public void addTag(T tag) {
    
    }
    
    @Override
    public int size() {
        return 0;
    }
    
    @Override
    public boolean isEmpty() {
        return false;
    }
    
    @Override
    public boolean contains(Object o) {
        return false;
    }
    
    @Override
    public @NotNull Iterator<T> iterator() {
        return null;
    }
    
    @Override
    public @NotNull Object[] toArray() {
        return new Object[0];
    }
    
    @Override
    public @NotNull <T1> T1[] toArray(@NotNull T1 @NotNull [] a) {
        return null;
    }
    
    @Override
    public boolean add(T t) {
        return false;
    }
    
    @Override
    public boolean remove(Object o) {
        return false;
    }
    
    @Override
    public boolean containsAll(@NotNull Collection<?> c) {
        return false;
    }
    
    @Override
    public boolean addAll(@NotNull Collection<? extends T> c) {
        return false;
    }
    
    @Override
    public boolean addAll(int index, @NotNull Collection<? extends T> c) {
        return false;
    }
    
    @Override
    public boolean removeAll(@NotNull Collection<?> c) {
        return false;
    }
    
    @Override
    public boolean retainAll(@NotNull Collection<?> c) {
        return false;
    }
    
    @Override
    public void clear() {
    
    }
    
    @Override
    public T get(int index) {
        return null;
    }
    
    @Override
    public T set(int index, T element) {
        return null;
    }
    
    @Override
    public void add(int index, T element) {
    
    }
    
    @Override
    public T remove(int index) {
        return null;
    }
    
    @Override
    public int indexOf(Object o) {
        return 0;
    }
    
    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }
    
    @Override
    public @NotNull ListIterator<T> listIterator() {
        return null;
    }
    
    @Override
    public @NotNull ListIterator<T> listIterator(int index) {
        return null;
    }
    
    @Override
    public @NotNull List<T> subList(int fromIndex, int toIndex) {
        return List.of();
    }
}
