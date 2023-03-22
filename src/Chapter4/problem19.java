package Chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem19 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());
        int[] array = new int[n];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i ++) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        // quick sort
        quickSort(array, 0, array.length-1, k);

        System.out.println(array[k-1]);
    }

    private static void quickSort(int[] array, int left, int right, int k) {
        if (left >= right) {
            return;
        }
        int pivot = partition(array, left, right);

        if (pivot == k) {
            return;
        }

        quickSort(array, left, pivot, k);
        quickSort(array, pivot+1, array.length-1, k);
    }

    private static int partition(int[] array, int left, int right) {
        int pivot = array[(left+right)/2];

        while(left < right) {
            while(array[left] < pivot) {
                left++;
            }

            while(array[right] > pivot) {
                right--;
            }

            if (left <= right) { // pivot
                swap(array, left, right);
            }

        }
        return right;
    }

    private static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
