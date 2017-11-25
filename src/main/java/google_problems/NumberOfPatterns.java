package google_problems;

/**
 * Created by jaloliddinbakirov on 11/24/17.
 */
public class NumberOfPatterns {
    public static void main(String[] args) {

    }

    public int numberOfPatterns(int m, int n) {
        int[][] skip = new int[10][10];

        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] = skip[3][7] = skip [7][3] = skip[6][4] = skip[4][6] = 5;

        boolean[] visited = new boolean[10];
        int totalNumber = 0;

        for (int i = m; i <= n; i++){
            totalNumber += dfs(skip, i - 1, visited, 1) * 4;
            totalNumber += dfs(skip, i - 1, visited, 2) * 4;
            totalNumber += dfs(skip, i-1, visited, 5);
        }

        return totalNumber;
    }

    public int dfs(int[][] skip, int remaining, boolean[] visited, int current){
        if (remaining < 0) return 0;
        if (remaining == 0) return 1;

        visited[current] = true;
        int totalNumber = 0;

        for (int i = 1; i <= 9; i++){
            if (!visited[i] && (skip[current][i] == 0 || visited[skip[current][i]])){
                totalNumber += dfs(skip, remaining-1, visited, i);
            }
        }

        visited[current] = false;

        return totalNumber;
    }

}
