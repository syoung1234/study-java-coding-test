package basic.sort;

import java.util.Arrays;

/**
 * 퀵 정렬 - 중앙값
 * 이미 정렬된 데이터에 대한 퀵 정렬의 성능을 약간 향상
 * 시간 복잡도 O(nlogn) ~ O(n^2)
 */
public class quickMid {
    public static void main(String[] args) {
        int[] array = {3, 5, 1, 7, 2};
        quickSort(array, 0, array.length-1);
        System.out.println("Arrays.toString(array) = " + Arrays.toString(array));
    }

    static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivot = partition(array, left, right);

            quickSort(array, left, pivot-1);
            quickSort(array, pivot+1, right);
        }

    }

    static int partition(int[] array, int left, int right) {
        int pivot = array[(left+right)/2];
        while (left < right) {
            while (array[left] < pivot) {
                left++;
            }

            while (array[right] > pivot) {
                right--;
            }

            if (left <= right) {
                // swap
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }

        return right;

    }
}
