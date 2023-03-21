package Chapter4;

import java.util.Scanner;

public class problem17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int[] array = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            array[i] = Integer.parseInt(str.substring(i, i+1));
        }

        // 내림차순 정렬 (선택 정렬 이용)
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (array[i] < array[j]) { // swap
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }

        for (int i = 0; i < str.length(); i++) {
            System.out.print(array[i]);
        }
    }
}
