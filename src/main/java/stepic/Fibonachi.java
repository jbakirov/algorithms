package stepic;

import java.util.Scanner;

/**
 * Created by Baka on 18.02.2016.
 */
public class Fibonachi {

    public static void main(String[] args) {

        System.out.println(fib(9));
    }

    static int fib(int n){
        if (n == 0){
            return 0;
        }else if (n == 1){
            return 1;
        }

        return fib(n-2) + fib(n-1);
    }

}
