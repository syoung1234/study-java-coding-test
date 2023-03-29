package Chapter5;

import java.util.Scanner;

public class problem24 {
    static int n;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt(); // 자릿수
        // 2, 3, 5, 7 -> 0, 1은 소수가 아니기 때문에 시작은 무조건 2, 3, 5, 7만 가능
        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);

    }

    static void DFS(int num, int jarisu) {
        if (jarisu == n) {
            if (isPrime(num)) {
                System.out.println(num);
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) { // 짝수
                continue;
            }
            if (isPrime(num * 10 + i)) {
                DFS(num * 10 + i, jarisu + 1);
            }
        }
    }

    static boolean isPrime(int num) {
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
