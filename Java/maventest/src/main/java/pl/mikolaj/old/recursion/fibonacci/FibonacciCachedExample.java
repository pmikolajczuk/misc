package pl.mikolaj.old.recursion.fibonacci;

public class FibonacciCachedExample {

    static long[] cache;

    public static void main(String[] args) {

        int n=50;
        cache = new long[n+1];
        System.out.println(fibonacci(n));

    }

    public static long fibonacci(int n) {
        long f = cache[n];
        if(f != 0) {
            return f;
        }
        if (n == 0) {
            return 0;
        }
        else if(n == 1) {
            return 1;
        }else {
            f = fibonacci(n-1) + fibonacci(n-2);
            cache[n] = f;
            return f;
        }
    }
}
