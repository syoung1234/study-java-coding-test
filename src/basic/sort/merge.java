package basic.sort;

import java.util.Arrays;

/**
 * 병합 정렬
 * 시간 복잡도 O(nlogn)
 */
public class merge {
    public static void main(String[] args) {
        int[] array = {3, 5, 1, 7, 2, 8, 4, 6};
        mergeSort(array, 0, array.length-1);
        System.out.println("Arrays.toString(array) = " + Arrays.toString(array));
    }

    static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left+right)/2;

            mergeSort(array, left, mid);
            mergeSort(array, mid+1, right);
            merge(array, left, mid, right);
        }

    }

    static void merge(int[] array, int left, int mid, int right) {
        // left 배열, right 배열 병합
        int[] leftArr = new int[mid - left + 1];
        int[] rightArr = new int[right - mid];

        for (int i = 0; i < mid-left+1; i++) {
            leftArr[i] = array[left+i];
        }

        for (int i = 0; i < right-mid; i++) {
            rightArr[i] = array[mid+1+i];
        }

        int i = 0;
        int j = 0;
        int k = left;
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                array[k++] = leftArr[i++];
            } else {
                array[k++] = rightArr[j++];
            }
        }

        // 나머지
        while (i < leftArr.length) {
            array[k++] = leftArr[i++];
        }

        while (j < rightArr.length) {
            array[k++] = rightArr[j++];
        }

    }
}
