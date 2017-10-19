package kormen;

/**
 * Created by Baka on 04.03.2016.
 */
public class MaximumSubarray {

    public static void main(String[] args) {
//        int[] array = new int[]{18, 20, -7, 12, 13, -3, -25, 20, -3, -16, -23,  -5, -22, 15, -4, 7};
        int[] array = new int[]{7, -3, 2, -1, 4, -5, 6};

//        Item item = findMaximumSubarray(array);

//        System.out.println("Left: " + item.leftLow + "; Right: " + item.rightHigh + "; Sum: " + item.maxSum);

        System.out.println("_______");
        int[] a = {3, 1, 2 , 1};

        findMaximumSubarrayTwoN(a);
    }

    public static Item findMaximumSubarray (int[] a){
        return findMaximumSubarray(a, 0, a.length-1);
    }

    public static Item findMaximumSubarray(int[] a, int low, int high){
        int mid = 0;

        Item item = new Item();

        if (high == low){
            item.leftLow = low;
            item.rightHigh = high;
            item.maxSum = a[high];
            return item;
        } else {
            mid = (low + high)/2;
        }

        Item leftSubarray = findMaximumSubarray(a, low, mid);
        Item rightSubarray = findMaximumSubarray(a, mid + 1, high);
        Item crossSubarray = findMaxCrossingSubarray(a, low, mid, high);

        if (leftSubarray.maxSum >= rightSubarray.maxSum && leftSubarray.maxSum >= crossSubarray.maxSum ){
            return leftSubarray;
        }else if (rightSubarray.maxSum >= leftSubarray.maxSum && rightSubarray.maxSum >= crossSubarray.maxSum){
            return rightSubarray;
        }else {
            return crossSubarray;
        }
    }


    public static Item findMaxCrossingSubarray (int[] a, int low, int mid, int high){

        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        int maxLeft = 0;

        for (int i = mid; i >= low; i--){
            sum = sum + a[i];
            if (sum > leftSum){
                leftSum = sum;
                maxLeft = i;
            }
        }

        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        int maxRight = 0;

        for (int i = mid + 1; i <= high; i++){
            sum = sum + a[i];
            if (sum > rightSum){
                rightSum = sum;
                maxRight = i;
            }
        }

        Item item = new Item();
        item.maxSum = leftSum + rightSum;
        item.leftLow = maxLeft;
        item.rightHigh = maxRight;

        return item;
    }

    public static class Item {
        long maxSum;
        long leftLow;
        long rightHigh;
    }

    public static void findMaximumSubarrayTwoN(int[] a){
        int sum = 0;
        int maxSum = 0;
        int f = 0;
        int l = 0;

        for (int i = 0; i < a.length; i++){
            for (int j = i; j < a.length; j++){
                sum = sum + a[j];
                if (sum >  maxSum){
                    if (j == i) f = j;
                    maxSum = sum;
                    l = j;
                }
            }
            sum = 0;
        }

        System.out.println(l-f + 1);
        System.out.println(maxSum);
        System.out.println("first: " + f + ", Last: " + l);
    }
}
