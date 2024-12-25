package part_04.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class DataContainer<T> {
    private final List<T> items = new ArrayList<>();

    public void add(T item){
        items.add(item);
    }
    public  boolean remove(T item){
        return items.remove(item);
    }
    public boolean contains(T item){
        return items.contains(item);
    }
    public T get(int index){
        return items.get(index);
    }
    public void foreach(Consumer<T> action){
        items.forEach(action);
    }
}
