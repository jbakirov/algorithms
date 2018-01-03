package kormen;

/**
 * Created by Baka on 01.03.2016.
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] array = new int[]{43, 21, 22, 5, 3, 15};

        sort1(array);

        for (int i : array){
            System.out.println(i);
        }
    }


    private static void sort(int[] a){

        for (int i = 0; i < a.length; i++){
            int min = a[i];
            int minIndex = i;
            for (int j = i+1; j < a.length; j++){
                if (a[j] < min){
                    min = a[j];
                    minIndex = j;
                }
            }
            swap(a, i, minIndex);
        }

    }

    public void sort2 (int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = a[i];
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < min) {
                    min = a[j];
                    minIndex = j;
                }
            }
            swap(a, i, minIndex);
        }
    }

    private static void sort1(int[] a){

        for (int i = 0; i < a.length; i++){
            int min = a[i];
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++){
                if (a[j] < min){
                    min = a[j];
                    minIndex = j;
                }
            }
            swap(a, i, minIndex);
        }
    }

    private static void swap(int[] a, int index, int index2){
        int temp = a[index];
        a[index] = a[index2];
        a[index2] = temp;
    }

}
