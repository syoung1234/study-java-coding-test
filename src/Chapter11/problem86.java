package Chapter11;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 이친수 구하기
 * 백준 2193번
 */
public class problem86 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Long[] zero = new Long[n+1];
        Long[] one = new Long[n+1];

        if (n == 1 || n == 2) {
            System.out.println(1);
        } else {
            // 고정값
            zero[1] = 0L;
            zero[2] = 1L;
            one[1] = 1L;
            one[2] = 0L;

            // 1 뒤에는 0만 올 수 있음 (1개), 0 뒤에는 0과 1 모두 올 수 있음 (2개)
            for (int i = 3; i < n+1; i++) {
                one[i] = zero[i-1];
                zero[i] = one[i-1] + zero[i-1];
            }

            System.out.println(one[n] + zero[n]);

            System.out.println("Arrays.toString(one) = " + Arrays.toString(one));
            System.out.println("Arrays.toString(zero) = " + Arrays.toString(zero));
        }
    }
}
