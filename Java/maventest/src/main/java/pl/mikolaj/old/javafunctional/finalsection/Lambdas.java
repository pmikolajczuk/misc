package pl.mikolaj.old.javafunctional.finalsection;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class Lambdas {
    public static void main(String[] args) {

        Integer number = null;
        String upperCasedName = upperCaseName.apply("Alex", 20);
        System.out.println(upperCasedName);
    }

    static BiFunction<String, Integer, String> upperCaseName = (name, age) -> {
        if(name.isBlank()) throw new IllegalStateException();
        System.out.println(age);
        return name.toUpperCase();
    };

    class Service {
        public Consumer<String> blah = s -> {};
    }


}
