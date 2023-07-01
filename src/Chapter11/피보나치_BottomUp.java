package Chapter11;

import java.util.Arrays;
import java.util.Scanner;

public class 피보나치_BottomUp {
    static int[] D;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        D = new int[n+1];
        for (int i = 0; i <= n; i++) {
            D[i] = -1;
        }
        D[0] = 0;
        D[1] = 1;
        for (int i = 2; i <= n; i++) {
            D[i] = D[i - 1] + D[i - 2];
        }
        System.out.println("Arrays.toString(D) = " + Arrays.toString(D));
    }
}
