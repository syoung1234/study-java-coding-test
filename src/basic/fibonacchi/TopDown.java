package basic.fibonacchi;

import java.util.Arrays;

/**
 * 피보나치 수열
 * DP, 재귀
 */
public class TopDown {
    public static void main(String[] args) {
        int n = 7;
        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;

        int answer = fibonacchi(dp, n);
        System.out.println("answer = " + answer);
        System.out.println("Arrays.toString(dp) = " + Arrays.toString(dp));
    }

    static int fibonacchi(int[] dp, int n) {
        if (n <= 1) {
            return n;
        }
        if (dp[n] == 0) {
            dp[n] = fibonacchi(dp, n-2) + fibonacchi(dp,n-1);
        }

        return dp[n];
    }
}
