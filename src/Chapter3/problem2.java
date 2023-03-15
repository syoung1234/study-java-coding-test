package Chapter3;

import java.util.Scanner;

public class problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] score = new int[n];
        int max = 0;
        double result = 0;
        for (int i = 0; i < n; i ++) {
            score[i] = scanner.nextInt();
            if (max < score[i]) {
                max = score[i];
            }
            result += score[i];
        }
        result = result / max * 100 / n;

        System.out.println(result);
    }
}
