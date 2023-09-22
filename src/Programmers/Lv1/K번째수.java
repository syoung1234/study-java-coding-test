package Programmers.Lv1;

import java.util.Arrays;

public class K번째수 {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2,5,3}, {4,4,1}, {1,7,3}};
        int[] answer = new int[commands.length];
        int answerIndex = 0;
        for (int[] command : commands) {
            int i = command[0];
            int j = command[1];
            int k = command[2];
            int[] newArray = new int[j-i+1];
            int index = 0;
            for (int a = i-1; a < j; a++) {
                newArray[index++] = array[a];
            }
            // 정렬
            Arrays.sort(newArray);

            answer[answerIndex++] = newArray[k-1];

        }

        System.out.println("answer = " + Arrays.toString(answer));
    }
}
