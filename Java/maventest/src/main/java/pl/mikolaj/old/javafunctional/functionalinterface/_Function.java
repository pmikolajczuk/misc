package pl.mikolaj.old.javafunctional.functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args){
        //int increment = increment(0);
        int increment = incrementByOneFunction.apply(1);
        System.out.println(increment);

        int multiply = multiplyBy10Function.apply(increment);
        System.out.println(multiply);

        Function<Integer, Integer> add1AndThenMultiplyBy10 = incrementByOneFunction.andThen(multiplyBy10Function);
        System.out.println(add1AndThenMultiplyBy10.apply(4));

        System.out.println(incrementByOneAndMultiply(1, 10));
        System.out.println(incrementByOneAndMultiplyFunction.apply(6, 10));
    }

    static Function<Integer, Integer> incrementByOneFunction = number -> ++number;

    static Function<Integer, Integer> multiplyBy10Function = number -> number * 10;

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyFunction =
        //(number, numToMultiplyBy) -> (number + 1) * numToMultiplyBy;
            _Function::incrementByOneAndMultiply;


    static int incrementByOneAndMultiply(int number, int numToMultiplyBy) {
        return ++number * numToMultiplyBy;
    }
}
