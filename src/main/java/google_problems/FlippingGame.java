package google_problems;

import java.util.Scanner;

/**
 * Created by jaloliddinbakirov on 11/27/17.
 *
 * wrong
 */
public class FlippingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] a = new int[n+1][4];

        for (int i = 1; i <= a[0].length; i++){
            a[0][i] = scanner.nextInt();
        }

        for (int i = 1; i <= a[0].length; i++){
            a[0][i] = Math.max(a[0][i], a[0][i] + a[0][i-1]);
            a[1][i] = Math.max(a[0][i-1], a[1][i-1]);
//            a[2][i] = Math.max(a[])
//            a[3][i] = Math.max(a[])
        }
    }
}
