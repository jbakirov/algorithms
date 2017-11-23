package practice;

/**
 * Created by Baka on 20.01.2017.
 */
public class SelectingSort {

    public static void main(String[] args) {
        int[] a = {4, 3, 1, 7, 12, 2, 30};
        sort(a);

        for (int i : a){
            System.out.println(i);
        }
    }

    public static void sort (int a[]){
        for (int i = 0; i < a.length; i++){
            int minInd = i;
            for (int j = i + 1; j < a.length; j++){
                if (a[minInd] > a[j]) minInd = j;
            }
            swap(a, minInd, i);
        }
    }


    public static void swap (int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

}
