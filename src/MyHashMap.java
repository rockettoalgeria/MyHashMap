import org.jetbrains.annotations.NotNull;

import java.util.*;

public class MyHashMap {

    private int multipliedSize;
    private int size;
    private int totalItems;
    private LinkedList[] map;

    public MyHashMap(int size) {
        init(size);
    }

    public MyHashMap() {
        int defualtSize = 16;
        init(defualtSize);
    }

    private void init(int size) {
        final float loadFactorMultiplier = 1.3f;
        this.size = size;
        this.multipliedSize = (int)(size * loadFactorMultiplier);
        totalItems = 0;
        map = new LinkedList[this.multipliedSize];
    }

    public float load() { return (float) totalItems / multipliedSize; }

    public boolean set(@NotNull String key, java.lang.constant.Constable value) {
        int bucket = Math.abs(key.hashCode() % multipliedSize);

        if (map[bucket] == null) {
            if (totalItems >= size)
                return false; // TODO: increase size of the map
            LinkedList<Object[]> list = new LinkedList<>();
            Object[] valuePair = {key, value};
            list.add(valuePair);
            map[bucket] = list;
        }
        else {
            Object[] newValuePair = {key, value};
            for (Object obj : map[bucket]) {
                Object[] current = (Object[]) obj;
                if(current[0] == key) {
                    map[bucket].remove(obj);
                    totalItems--;
                    break;
                }
            }
            if (totalItems >= size)
                return false; // TODO: increase size of the map
            map[bucket].add(newValuePair);
        }
        totalItems++;
        return true;
    }

    public Object get(String key) {
        int bucket = Math.abs(key.hashCode() % multipliedSize);

        if (map[bucket] != null) {
            for (Object obj : map[bucket]) {
                Object[] current = (Object[]) obj;
                if (current[0] == key)
                    return current[1];
            }
        }
        return null;
    }

    public Object delete(String key) {
        int bucket = Math.abs(key.hashCode() % multipliedSize);

        if (map[bucket] != null) {
            for (Object obj : map[bucket]) {
                Object[] current = (Object[]) obj;
                if (current[0] == key) {
                    Object value = current[1];
                    map[bucket].remove(obj);
                    totalItems--;
                    return value;
                }
            }
        }
        return null;
    }
}
