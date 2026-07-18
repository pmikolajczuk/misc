package pl.mikolaj.old.john.lambdas;

import java.util.function.BiFunction;

public class Lambdas {

    public static void main(String[] args) {
        BiFunction<String, String, String> printableLambda = (p, s) -> p + " I'm a lambda " + s;
        printThing(printableLambda);
    }

    static void printThing(BiFunction<String, String, String> thing) {
        System.out.println(thing.apply("Hello","!"));
    }
}
