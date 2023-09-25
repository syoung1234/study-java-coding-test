package basic.sort;


import java.util.Arrays;

/**
 * 삽입 정렬
 * 시간 복잡도: O(n^2)
 * 첫 번째 원소는 정렬된 것으로 간주
 */
public class insertion {
    public static void main(String[] args) {
        int[] array = {3, 5, 1, 7, 2};
        int len = array.length;

        for (int i = 1; i < len; i++) {
            int target = array[i];
            int num = i;
            for (int j = i-1; j >= 0; j--) {
                if (target < array[j]) {
                    array[num] = array[j];
                    array[j] = target;
                    target = array[j];
                    num--;
                } else {
                    break;
                }
            }
        }

        System.out.println("Arrays.toString(array) = " + Arrays.toString(array));
    }
}
