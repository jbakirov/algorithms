package stepic;

/**
 * Created by Baka on 18.02.2016.
 */
public class NOD {
    public static void main(String[] args) {
        System.out.println(calc(10, 4));
    }

    /*
    Euclid's Algorithm
     */

    static int calc (int a, int b){
        if (a == 0) {
            return b;
        }else if (b == 0){
            return a;
        }else if (a >= b){
            return calc(a % b, b);
        }else if (a <= b){
            return calc(a, b % a);
        }
        return 0;
    }
}
