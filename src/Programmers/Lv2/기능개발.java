package Programmers.Lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42586
 */
public class 기능개발 {
    public static void main(String[] args) {
        int[] progresses = {99,99,99};
        int[] speeds = {1,1,1};
        solution(progresses, speeds);
    }

    // Queue
    // 0.12ms ~ 1.16ms
    static ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int len = progresses.length;

        boolean[] complete = new boolean[len];
        for (int i = 0; i < len; i++) {
            queue.add(i);
        }

        int j = 0;
        int count = 0;
        while(!queue.isEmpty()) {
            if (progresses[j] >= 100) {
                complete[j] = true;
                while(!queue.isEmpty() && complete[queue.peek()]) {
                    queue.remove();
                    count++;
                }
            } else {
                progresses[j] += speeds[j];
            }

            j++;
            if (j >= progresses.length) {
                j = 0;
                if (count > 0) {
                    arrayList.add(count);
                    count = 0;
                }
            }
        }

        if (count > 0) {
            arrayList.add(count);
        }

        System.out.println("arrayList = " + arrayList);
        return arrayList;
    }

    /**
     * ArrayList 반환 결과가 가장 빠름
     * stream 코드는 짧지만 가장 오래 걸림
     */
    static ArrayList<Integer> solution2(int[] progresses, int[] speeds) {
        int day = 1;
        int[] end = new int[100];
        for (int i = 0; i < progresses.length; i++) {
            while (progresses[i] + day * speeds[i] < 100) {
                day++;
            }
            end[day]++;
        }

        ArrayList<Integer> arrayList = new ArrayList();
        for (int i = 0; i < 100; i++) {
            if (end[i] != 0) {
                arrayList.add(i);
            }
        }
        System.out.println("arrayList = " + arrayList);
        return arrayList; // 0.02ms ~ 0.07ms


        // 2.04ms ~ 19.82ms
        // return Arrays.stream(end).filter(i -> i != 0).toArray();
    }
}
