package Chapter11;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 퇴사 준비하기
 * 백준 14501번
 * i++ 로는 풀 수 없었음, i-- 로 풀 수 있음 => 문제 잘 파악해서 정하기
 */
public class problem85 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] T = new int[n+1];
        int[] P = new int[n+1];
        int[] array = new int[n+2];
        T[0] = 0;
        P[0] = 0;
        array[0] = 0;
        for (int i = 1; i <= n; i++) {
            T[i] = scanner.nextInt();
            P[i] = scanner.nextInt();
        }

        for (int i = n; i > 0; i--) {
            if (i + T[i] <= n + 1) {
                int pay = P[i] + array[i + T[i]];
                array[i] = Math.max(array[i + 1], pay);
            } else {
                array[i] = array[i+1];
            }
        }

        System.out.println(array[1]);
        System.out.println("Arrays.toString(array) = " + Arrays.toString(array));
    }
}
