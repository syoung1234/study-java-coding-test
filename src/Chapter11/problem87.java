package Chapter11;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 2*N 타일 채우기
 * 백준 11726번
 * 1007 은 소수이며 모든 수랑 서로소이므로 큰 수를 연산할 때 크기를 줄이는 용도로 많이 쓰임
 * 더 큰수라면 100000007 더 크게 만들면 됨
 */
public class problem87 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] dp = new long[1001];

        dp[1] = 1; // 2*1 타일 1개
        dp[2] = 2; // 2*1, 1*2

        for (int i = 3; i <=n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }
        System.out.println(dp[n]);
        System.out.println("Arrays.toString(dp) = " + Arrays.toString(dp));
    }
}
