package Chapter4;

import java.io.*;
import java.util.Arrays;

public class problem20 {
    public static int[] tmpArr;
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] array = new int[n];
        tmpArr = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(bufferedReader.readLine());
        }

        // divide
        merge_sort(array, 0, n-1);

        System.out.println(Arrays.toString(array));

        for (int i = 0; i < n; i++) {
            bufferedWriter.write(array[i] + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();

    }

    public static void merge_sort(int[] array, int left, int right) {
        if (left == right) { // 1개의 원소 값을 가질때 리턴 (더 이상 쪼갤 수 없음)
            return;
        }

        int mid = (left + right) / 2;
        merge_sort(array, left, mid);
        merge_sort(array, mid+1, right);

        merge(array, left, mid, right);
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int i = left;
        int m = mid+1;
        int l = left;
        while (l <= mid && m <= right) {
            if (array[l] < array[m]) {
                tmpArr[i] = array[l];
                l++;
            } else {
                tmpArr[i] = array[m];
                m++;
            }
            i++;
        }

        // 남은 원소들
        if (l > mid) {
            while (m <= right) {
                tmpArr[i] = array[m];
                m++;
                i++;
            }

        } else {
            while (l <= mid) {
                tmpArr[i] = array[l];
                l++;
                i++;
            }
        }


        for (int j = left; j <= right; j++) {
            array[j] = tmpArr[j];
        }

    }
}
