package Chapter4;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class problem22 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] array = new int[n];
        int[] simpleArr = new int[10001];

        for (int i = 0; i < n; i++) {
            int index = Integer.parseInt(bufferedReader.readLine());
            array[i] = index;
            simpleArr[index]++;
        }

        bufferedReader.close();
        radix_sort(array, 5);
        for (int i = 0; i < n; i++) {
            bufferedWriter.write(array[i] + "\n");
        }

//        for (int i = 0; i < 10001; i++) {
//            for(int j = 0; j < simpleArr[i]; j++) {
//                bufferedWriter.write(i + "\n");
//            }
//        }
        bufferedWriter.flush();
        bufferedWriter.close();

    }


    public static void radix_sort(int[] array, int max_size) {
        int[] output = new int[array.length];
        int jarisu = 1;
        int count = 0;
        while (count != max_size) {
            int[] bucket = new int[10];
            for (int i = 0; i < array.length; i++) {
                bucket[(array[i]/jarisu) % 10]++;
            }
            for (int i = 1; i < 10; i++) {
                bucket[i] += bucket[i-1];
            }
            for (int i = array.length - 1; i >= 0; i--) {
                output[bucket[(array[i]/jarisu % 10)]-1] = array[i];
                bucket[(array[i] / jarisu) % 10]--;
            }
            for (int i = 0; i < array.length; i++) {
                array[i] = output[i];
            }
            jarisu = jarisu * 10;
            count++;
        }
    }

    public static void radixSort(int[] array, int max_size) {
        int jarisu = 1;
        int count = 0;
        Queue<Integer>[] queueArr = new Queue[10];
        for (int i = 0; i < 10; i++) {
            queueArr[i] = new LinkedList<>();
        }

        while (count != max_size) {
            for (int i = 0; i < array.length; i++) {
                int index = array[i] / jarisu % 10;
                queueArr[index].add(array[i]);
            }

            int j = 0;
            for (int i = 0; i < 10; i++) {
                while(!queueArr[i].isEmpty()) {
                    array[j] = queueArr[i].poll();
                    j++;
                }
            }
            count++;
            jarisu = jarisu * 10;
        }

    }
}
