package kormen.dynamic_programming;

/**
 * Created by Baka on 20.04.2016.
 */
public class BottomUpCutRod {

    public static void main(String[] args) {
        int p[] = new int[]{1, 5, 8, 9, 10, 16};

        int i[] = new BottomUpCutRod().bottomUpCutRodArray(p);

        for (int k : i ){
            System.out.println(k);
        }
    }

    public int bottomUpCutRod(int[] p) {
        int[] r = new int[p.length + 1];
        r[0] = 0;

        for (int j = 0; j < p.length; j++){
            int q = -1;
            for (int i = 0; i <= j; i++){
                q = Math.max(q, p[i] + r[j-i]);
            }
            r[j] = q;
        }

        return r[p.length - 1];
    }

    public int[] bottomUpCutRodArray(int[] p) {
        int[] r = new int[p.length + 1];
        int[] s = new int[p.length + 1];

        r[0] = 0;

        for (int j = 0; j < p.length; j++){
            int q = -1;
            for (int i = 0; i <= j; i++){
                if (q < p[i] + r[j-i]){
                    q = p[i] + r[j-i];
                    s[j] = i;
                }
            }
            r[j] = q;
        }

        System.out.println(r[p.length - 1]);
        return s;
    }
}
