package Chapter3;

import java.util.Scanner;

public class problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String nNum = scanner.next();

        char[] array = nNum.toCharArray();

        int result1 = 0;
        int result2 = 0;
        for (int i = 0; i < n; i++) {
            // 첫 번째 방법
            result1 += array[i] - 48; // 아스키코드 빼야됨.. 48 = '0'

            // 두 번째 방법
            String stringNum = String.valueOf(array[i]);
            result2 += Integer.parseInt(stringNum);
        }

        System.out.println(result1);
        System.out.println(result2);
    }
}
