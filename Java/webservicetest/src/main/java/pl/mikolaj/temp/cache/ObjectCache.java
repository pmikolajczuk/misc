package pl.mikolaj.temp.cache;

import pl.mikolaj.temp.model.HasId;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SuppressWarnings("unchecked")
public class ObjectCache {
    private static final Map<Class<?>, Map<Integer, ?>> cache = new HashMap<>();

    public static <T extends HasId> void putAll(Class<T> clazz, List<T> objects) {
        cache.put(clazz, objects.stream().collect(Collectors.toMap(HasId::getId, t -> t)));
    }

    public static <T> Collection<T> getAll(Class<T> clazz) {
        return (Collection<T>) cache.get(clazz).values();
    }

    public static <T> T getById(Class<T> clazz, Integer id) {
        return (T) cache.get(clazz).get(id);
    }
}
