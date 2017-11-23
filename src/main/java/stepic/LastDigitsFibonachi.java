package stepic;

/**
 * Created by Baka on 18.02.2016.
 */
public class LastDigitsFibonachi {

    public static void main(String[] args) {
        System.out.println(fibLoop(3));
    }

    /*
    takes too long
     */
    static int fib(int i){

        if (i == 0){
            return 0;
        }else if (i == 1){
            return 1;
        }

        int r = fib(i-1) + fib(i-2);

        return r % 10;
    }

    /*
    this solution works faster than previous
     */
    static int fibLoop (int n){
        int num0 = 0;
        int num1 = 1;
        int fibanachi = 0;
        for (int i = 1; i < n; i++){

            fibanachi = (num0 + num1) % 10;
            num0 = num1;
            num1 = fibanachi;
        }
        return fibanachi;

    }

}
