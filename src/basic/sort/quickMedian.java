package basic.sort;

import java.util.Arrays;

/**
 * 퀵 정렬 - Median of Three
 * 첫 번째, 중간, 마지막 요소 중 중앙값을 피벗으로 선택
 * 평균적인 성능을 향상, 정렬된 데이터에 대한 퀵 정렬의 성능 향상
 */
public class quickMedian {
    public static void main(String[] args) {
        int[] array = {3, 5, 1, 7, 2, 8, 4};
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
        int pivot = medianOfThree(array, left, right);


        while (left < right) {
            while (array[left] < pivot) {
                left++;
            }

            while (array[right] > pivot) {
                right--;
            }

            if (left <= right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }

        return left;

    }

    static int medianOfThree(int[] array, int left, int right) {
        int mid = (left+right)/2;

        if (array[mid] < array[left]) {
            swap(array, left, mid);
        }
        if (array[left] > array[right]) {
            swap(array, left, right);
        }
        if (array[mid] > array[right]) {
            swap(array, mid, right);
        }

        return array[right];
    }

    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
