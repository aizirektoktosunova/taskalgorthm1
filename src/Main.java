
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        char[][] forest = new char[n][3];
        for (int i = 0; i < n; i++) {
            forest[i] = scanner.nextLine().toCharArray();
        }

        int[][] dp = new int[n][3];
        for (int j = 0; j < 3; j++) {
            if (forest[0][j] == 'C') {
                dp[0][j] = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (forest[i][j] == 'C') {
                    dp[i][j] = 1;
                    if (j > 0 && forest[i-1][j-1] != 'W') {
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + 1);
                    }
                    if (forest[i-1][j] != 'W') {
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][j] + 1);
                    }
                    if (j < 2 && forest[i-1][j+1] != 'W') {
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][j+1] + 1);
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        int maxMushrooms = 0;
        for (int j = 0; j < 3; j++) {
            maxMushrooms = Math.max(maxMushrooms, dp[n-1][j]);
        }
        if (maxMushrooms > 1) {
            System.out.println(maxMushrooms + 1);
        } else {
            System.out.println(maxMushrooms);
        }
    }
}


