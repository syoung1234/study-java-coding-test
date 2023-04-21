package Chapter7;

import java.util.Scanner;
import java.util.Stack;

public class problem45 {
    static Stack<Long> share = new Stack<>(); // 몫
    static long preX = 1;
    static long preY = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int gcd = gcd(a, b);

        if (c % gcd != 0) {
            System.out.println(-1);
            return;
        }

        long x = 0;
        long y = 0;

        while(!share.isEmpty()) {
            // x=y', y=x'-y'*q
            x = preY;
            y = preX - preY * share.pop();
            preX = x;
            preY = y;
        }

        if (c % gcd == 0) { // 확장된 유클리드 호제법 조건 만족
            // 배수 확인하기
            long num = c / gcd;
            x = x * num;
            y = y * num;
            System.out.println(x + " " + y);
        }

    }


    // 최대 공약수 구하기
    static int gcd(int a, int b) {
        while(b != 0) {
            int r = a % b;
            long s = a / b;
            a = b;
            b = r;

            share.push(s);
        }
        return a;
    }
}
