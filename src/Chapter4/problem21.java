package Chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem21 {
    public static int[] tmpArr;
    public static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] array = new int[n];
        tmpArr = new int[n];

        for (int i = 0; i < n; i ++) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        merge_sort(array, 0, n-1);

        System.out.println(result);

    }

    public static void merge_sort(int[] array, int left, int right) {
        if (left == right) return;

        int mid = (left + right) / 2;
        merge_sort(array, left, mid);
        merge_sort(array, mid+1, right);

        merge(array, left, mid, right);
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int i = left;
        int m = mid + 1;
        int l = left;

        while(l <= mid && m <= right) {
            if (array[l] < array[m]) {
                tmpArr[i] = array[l];
                if (l - i > 0) {
                    result += l-i;
                }
                l++;
            } else {
                tmpArr[i] = array[m];
                if (m - i > 0) {
                    result += m-i;
                }
                m++;
            }
            i++;
        }

        if (l > mid) {
            while (m <= right) {
                tmpArr[i] = array[m];
                if (m - i > 0) {
                    result += m-i;
                }
                m++;
                i++;
            }
        } else {
            while (l <= mid) {
                tmpArr[i] = array[l];
                if (l - i > 0) {
                    result += l-i;
                }
                l++;
                i++;
            }
        }

        for (int j = left; j <= right; j++) {
            array[j] = tmpArr[j];
        }

    }
}
