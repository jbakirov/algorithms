package Sorting;

/**
 * Created by Baka on 17.01.2016.
 */
public class BubbleSorting {

    public static void main (String[] args){
        int[] a = {3, 2, 5, 4};
        new BubbleSorting().bubbleSorting1(a);

        for (int i:a){
            System.out.println(i);
        }
    }

    void bubbleSorting (int[] a){
        for (int i = 0; i < a.length - 1; i++){
            for (int j = 1; j < a.length - i; j++){
                if (a[j - 1] > a[j]){
                    int tmp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }

    void bubbleSorting1 (int[] a){
        for (int i = 0; i < a.length - 1; i++){
            for (int j = 1; j < a.length - i; j++){
                if (a[j-1] > a[j]){
                    int tmp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }

    void bubbleSorting2 (int[] a){
        for (int i = 0; i < a.length -1; i++){
            for (int j = 1; j < a.length; j++){
                if (a[j-1] > a[j]){
                    int tmp = a[j-1];
                    a[j - 1] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }


    void bubbleSorting3 (int[] a){
        for (int i = 0; i < a.length - 1; i++){
            for (int j = 1; j < a.length; j++){
                if (a[j-1] > a[j]){
                    int tmp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }

}
