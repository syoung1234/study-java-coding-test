package Chapter11;

import java.util.Scanner;

/**
 * 정수를 1로 만들기
 * 백준 1463번
 * !점화식 찾는 것 중요!
 */
public class problem84 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] D = new int[n+1];

        D[0] = 0;
        D[1] = 0; // 연산 1번도 안일어남

        for (int i = 2; i <= n; i++) {
            D[i] = D[i - 1] + 1;
            if (i % 2 == 0) {
                D[i] = Math.min(D[i], D[i / 2] + 1);
            }
            if (i % 3 == 0) {
                D[i] = Math.min(D[i], D[i / 3] + 1);
            }
        }
        System.out.println(D[n]);
    }
}
