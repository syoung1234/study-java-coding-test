package basic.sort;

import java.util.Arrays;

/**
 * 선택 정렬
 * 시간 복잡도 O(n^2)
 * 가장 작은(or큰) 원소 찾기
 */
public class selection {
    public static void main(String[] args) {
        int[] array = {3, 5, 1, 7, 2};
        int len = array.length;

        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        System.out.println("Arrays.toString(array) = " + Arrays.toString(array));
    }
}
