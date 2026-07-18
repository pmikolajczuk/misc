package pl.mikolaj.old.misc.maps;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MapMultiExamples {
    public static void main(String[] args) {
            example1();
    }

    public static void example1() {
        class MapMultiDistinctMapper<T, R> implements BiConsumer<T, Consumer<R>> {

            Set<T> previous = new HashSet<>();

            @Override
            @SuppressWarnings("unchecked")
            public void accept(T element, Consumer<R> consumer) {
                if (!previous.contains(element)) {
                    consumer.accept((R)element);
                    previous.add(element);
                }
            }
        }

        IntStream.rangeClosed(1, 30)
                .boxed()
                .flatMap(integer -> Stream.of(integer, integer, integer))
                .mapMulti(new MapMultiDistinctMapper<Integer, Integer>())
                .toList()
                .forEach(System.out::println);
    }
}
