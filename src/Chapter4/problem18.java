package Chapter4;

import java.util.Scanner;

public class problem18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        for (int i = 1; i < n; i++) {
            int target = array[i];
            int num = i;
            for (int j = i-1; j >= 0; j--) {
                if (target < array[j]) { // swap
                    array[num--] = array[j];
                    array[j] = target;
                    target = array[j];
                } else {
                    break;
                }
            }
        }


        int[] sumArr = new int[n];
        sumArr[0] = array[0];
        for (int i = 1; i < n; i++) {
            sumArr[i] = sumArr[i-1] + array[i];
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += sumArr[i];
        }

        System.out.println(result);
    }
}
