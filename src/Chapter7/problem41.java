package Chapter7;

import java.util.Scanner;

public class problem41 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long result = n;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                // 제곱근에 해당하므로 p[i] = p[i] - p[i]/k
                // 소수가 아닐 경우 위에 넘어가야함
                result = result - result/i;
                while (n % i == 0) {
                    n = n / i;
                }
            }
        }

        if (n > 1) {
            result = result - result/n;
        }

        System.out.println(result);
    }
}
