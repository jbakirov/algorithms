package fibanachi;

/**
 * Created by Baka on 07.12.2015.
 */
public class Fibanachi {

    public static void main(String[] args) {
        System.out.println(new Fibanachi().fib(3));
    }

    public int fib(int n) {

        if (n == 1) return 1;
        if (n == 2) return 1;

        return fib(n - 1) + fib(n - 2);
    }
}
