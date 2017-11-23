package practice.practice5;

/**
 * Created by Baka on 24.01.2017.
 */
public class QuicksortLomuto {

    public static void main(String[] args){
        int[] a = {99, 33, 22, 11, 1};
        sort(a);

        for (int i : a){
            System.out.println(i);
        }
    }

    private static void sort(int[] a){
        sort(a, 0, a.length-1);
    }

    private static void sort(int[] a, int start, int end){

        if (start >= end) return;
        int p = partition(a, start, end);
        sort(a, start, p-1);
        sort(a, p+1, end);
    }

    private static int partition(int[] a, int start, int end){
        int p = start;

        for(int i = start; i < end; i++){
            if (a[i] <= a[end]){
                exchange(a, i, p);
                p++;
            }
        }
        exchange(a, p, end);
        return p;
    }

    private static void exchange(int[] a, int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }


}
