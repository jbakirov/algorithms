package quizfulnet;

/**
 * Created by Baka on 09.03.2016.
 */
public class Main {

    public static void main(String[] args) {
        method();
    }

    static void method (){
        int n =3, k = 5;

        while (n != k){
            n = (n*2) % 11;
            k = (k*7) % 11;
        }

        System.out.println(n);
    }

}
