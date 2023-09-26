package basic.fibonacchi;

import java.util.Arrays;

/**
 * 피보나치 수열
 * 반복
 */
public class BottomUp {
    public static void main(String[] args) {
        int n = 7;
        int[] dp = new int[n+1];

        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println("Arrays.toString(dp) = " + Arrays.toString(dp));
    }
}
