package pl.mikolaj.old.recursion.memoize;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.function.Function;

public class Memoize<T, R> {

    public Function<T, R> memoizeFn(Function<T, R> fn) {
        Map<T, R> cache = new HashMap<>();
        return x -> cache.computeIfAbsent(x, fn);
    }

    @Deprecated
    public Function<T, R> memoizeFnOld(Function<T, R> fn) {
        Map<T, R> cache = new HashMap<>();
        return x -> mapCached(fn, cache, x);
    }

    private R mapCached(Function<T, R> fn, Map<T, R> cache, T x) {
        if(cache.get(x) != null) {
            return cache.get(x);
        } else {
            R result = fn.apply(x);
            cache.put(x, result);
            return result;
        }
    }

}
