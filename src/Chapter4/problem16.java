package Chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class problem16 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        bubbleData[] array = new bubbleData[n];
        for (int i = 0; i < n; i++) {
            array[i] = new bubbleData(i, Integer.parseInt(bufferedReader.readLine()));
        }

        Arrays.sort(array);
        int max = 0;
        for (int i = 0; i < n; i++) {
            // System.out.println(array[i].index + ", " + array[i].value);
            if (array[i].index - i > max) {
                max = array[i].index - i;
            }
        }
        System.out.println(max+1);

    }

    static class bubbleData implements Comparable<bubbleData> {
        int index;
        int value;

        bubbleData(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(bubbleData o) {
            return this.value - o.value;
        }
    }
}
