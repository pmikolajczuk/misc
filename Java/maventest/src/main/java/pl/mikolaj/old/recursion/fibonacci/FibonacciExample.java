package pl.mikolaj.old.recursion.fibonacci;

import pl.mikolaj.old.recursion.memoize.Memoize;

import java.util.function.Function;

public class FibonacciExample {
    public static void main(String[] args) {
//        System.out.println(fibonacci(45));
//        System.out.println(fibonacci(45));
//        System.out.println(fibonacci(45));

//        Memoize<Integer, Integer> memoize = new Memoize<>();
//        Function<Integer, Integer> memoizeFibonacci = memoize.memoizeFn(FibonacciExample::fibonacci);
//        System.out.println(memoizeFibonacci.apply(45));
//        System.out.println(memoizeFibonacci.apply(45));
//        System.out.println(memoizeFibonacci.apply(45));

        FibonacciFast fibonacciFast = new FibonacciFast();
        System.out.println(fibonacciFast.fibonacciFast(40));
        System.out.println(fibonacciFast.fibonacciFast(40));
    }

    private static int fibonacci(int n) {
        return n <= 1 ? n : fibonacci(n - 1) + fibonacci(n - 2);
    }

    private static class FibonacciFast {
        Memoize<Integer, Integer> memoize = new Memoize<>();
        Function<Integer, Integer> memoizeFibonacciFast = memoize.memoizeFn(this::fibonacciFast);

        private int fibonacciFast(int n) {
            return n <=1 ? n :  memoizeFibonacciFast.apply(n - 1) + memoizeFibonacciFast.apply(n - 2);
        }
    }
}
