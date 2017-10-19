package stepic;

/**
 * Created by Baka on 18.02.2016.
 */
public class DifficultFibonachi {

    public static void main(String[] args) {
        System.out.println(binPow(5, 2));
    }

    static int fibLoop(int n) {
        int num0 = 0;
        int num1 = 1;
        int fibanachi = 0;
        for (int i = 1; i < n; i++) {

            fibanachi = (num0 + num1) % 10;
            num0 = num1;
            num1 = fibanachi;
        }
        return fibanachi;

    }

    static long binPow(long a, int n) {
        long m;
        long res = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                res *= a;
//                res %= m;

            }
        }
        return res;
    }
}


