package basic.sort;

import java.util.Arrays;

/**
 * 버블 정렬 (Bubble Sort)
 * 시간 복잡도 O(n^2)
 * 오름차순: 1번 순회할 때마다 가장 큰 값이 가장 오른쪽에 위치하게 됨
 */
public class bubble {
    public static void main(String[] args) {
        int[] array = {3, 5, 1, 7, 2};
        int len = array.length;

        // 오름차순 정렬
        for (int i = 0; i < len-1; i++) {
            for (int j = 0; j < len-1-i; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

        System.out.println("Arrays.toString(array) = " + Arrays.toString(array));

        // 내림차순 정렬
        for (int i = 0; i < len-1; i++) {
            for (int j = 0; j < len-1-i; j++) {
                if (array[j] < array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

        System.out.println("Arrays.toString(array) = " + Arrays.toString(array));
    }
}
