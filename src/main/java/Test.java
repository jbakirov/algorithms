import java.util.*;

/**
 * Created by Baka on 20.01.2016.
 */
public class Test {

    static Comparator<Integer> idComparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    };


//    public static void main(String[] args) {
//        System.out.println(pow(3, 3));
//
    
//        Set<String> s = new HashSet<>();
//        s.add("s");
//
//        int[] a = new int[]{ 43, 2,  12, 0, 22, 1, 1};
//        new Test().bubbleSort(a);
//        System.out.println(Arrays.toString(a));
//    }

    enum Coffee {MEDIUM, DARK, DECAF}

    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++){
//            System.out.println(Math.ceil(Math.random() * 100));
//        }

        Coffee myCup = Coffee.DARK;

        LinkedList<Integer> linkedList = new LinkedList<>();
        ListIterator i = linkedList.listIterator();


    }


    void bubbleSort (int[] a){
        for (int i = 0; i < a.length - 1; i++){
            for (int j = 1; j < a.length - i; j++){
                if (a[j-1] > a[j]){
                    int temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    static int fibanachi(int n){
        if (n == 0){
            return 1;
        } else if (n == 1){
            return 1;
        }

        return fibanachi(n-1) + fibanachi(n-2);
    }


    static int pow(int x, int n){

        if (n == 0){
            return 1;
        }
        if (n < 0){
            return 1/pow(x, n);
        }
        if (isEven(n)){
            int temp = pow(x, n/2);
            return temp * temp;
        }
        if (isOdd(n)){
            return pow(x, n-1) * x;
        }

        return 0;
    }

    static boolean isEven(int n){
        if(n % 2 == 0){
            return true;
        }
        return false;
    }

    static boolean isOdd(int n){
        if (!isEven(n)){
            return true;
        }
        return false;
    }
}
