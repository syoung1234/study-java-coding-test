package Chapter11;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 계단 수 구하기
 * 백준 108244번
 * % 1000000000 해주는 곳 조심!
 */
public class problem88 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[][] dp = new long[n+1][10];

        // 한자리 수 - 0은 시작할 수 없음
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i < n+1; i++) {
            for (int j = 0; j < 10; j++) {
                // j == 0 일 때
                if (j == 0) { // 1 밖에 없음
                    dp[i][j] = dp[i-1][1] % 1000000000;
                } else if (j == 9) { // j == 9 일 때
                    dp[i][j] = dp[i-1][8] % 1000000000;
                } else {// 0 < j < 10
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
                }
            }
        }

        Long result = 0L;
        for (int i = 0; i < 10; i++) {
            result = (result + dp[n][i]) % 1000000000; // ( ) 괄호 안묶어줘서 틀렸었음!
        }

        System.out.println(result);

    }
}
