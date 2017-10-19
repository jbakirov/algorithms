package google_problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Baka on 15.11.2016.
 */
public class Google {
    private int[] holder = new int[100];
    private int start = -1;
    private String result = "", s;

    private String findRange(List<Integer> nums) {
        if(nums == null || nums.size() == 0)return "0-99";
        for(int n : nums){
            holder[n] = 1;
        }
        for (int i = 0; i<100; i++) {
            if(holder[i]==0) {
                if(start == -1) start = i;
            } else {
                if(start != -1) {
                    if(i-start == 1) s = ""+start;
                    else s = start + "-" + (i-1);
                    result += (result.equals("")?"":",")
                            + s;
                    start = -1;
                }
            }
        }
        if(start != -1)
            result += (result.equals("")?"":",")
                    + ((99-start != 0)?start + "-":"") + 99;
        return result;
    }

    public String myFindRange (List<Integer> list){

        ArrayList<Integer> arrayList = (ArrayList<Integer>) list;
        Integer[] a = new Integer[arrayList.size()];
        a = arrayList.toArray(a);
        StringBuilder r = new StringBuilder();

        for (int i = 1; i < a.length; i++){
            if (a[i] - a[i-1] > 1){
                if (a[i] - a[i-1] == 2) r.append(String.valueOf(a[i] - 1) + ",");
                else r.append(String.valueOf(a[i-1] + 1) + "-" + String.valueOf(a[i]-1) + ",");
            }
        }

        if (r.length() > 0) r.setCharAt(r.length()-1, ' ');

        return r.toString();
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(50);
        list.add(52);
        list.add(75);
        list.add(98);
        System.out.println(new Google().myFindRange(list));
    }
}
