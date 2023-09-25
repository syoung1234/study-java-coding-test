package basic.sort;

import java.util.Arrays;

/**
 * 퀵 정렬 - pivot 왼쪽 (첫 번째 요소)
 * 코드가 직관적이지만, 이미 정렬된 배열일 경우 최악의 성능
 * 시간 복잡도 O(nlogn) ~ O(n^2)
 */
public class quickLeft {
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
        int pivot = array[left];
        int pivotIndex = left;
        left++;
        while (left <= right) {
            while (left <= right && array[left] < pivot) {
                left++;
            }

            while (left <= right && array[right] > pivot) {
                right--;
            }

            if (left < right) {
                // swap
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }

        }

        // 교차 됐기 때문에 right
        array[pivotIndex] = array[right];
        array[right] = pivot;

        return right;

    }
}
