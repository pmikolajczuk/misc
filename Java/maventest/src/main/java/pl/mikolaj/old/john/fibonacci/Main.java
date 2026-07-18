package pl.mikolaj.old.john.fibonacci;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static long[] cache;

    public static void main(String[] args) {
        int n = 50;
        cache = new long[n+1];
        long result = fibonacci(n);
        System.out.println(result);
    }
    //1,2,3,5,8,13

    private static long fibonacci(int n) {
        long f = cache[n];
        if(f != 0) {
            return f;
        }
        //else

        if(n>1) {
            f =  fibonacci(n-1) + fibonacci(n-2);
            cache[n] = f;
            return f;
        } else if(n==1) {
            return 1;
        } else if(n==0) {
            return 0;
        }
        return -1;
    }
}
