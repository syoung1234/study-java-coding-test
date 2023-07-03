package Programmers.Lv2;

import java.util.ArrayList;
import java.util.Collections;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/131130
 * 굳이 ArrayList 2개 쓰지 않아도 풀 수 있었음 => 예시 코드 참고하기
 */
public class 혼자_놀기의_달인 {
    public static void main(String[] args) {
        int[] cards = {8,6,3,7,2,5,1,4};
        solution(cards);
        example(cards);
    }

    static int solution(int[] cards) {
        int answer = 1;
        int length = cards.length;
        boolean[] visited = new boolean[length+1];
        int i = cards[0];
        ArrayList<Integer> groupSize = new ArrayList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        int num = 0;
        int j = 1;
        int max = 0;
        while (length+1 != num) {
            if (visited[i-1]) { // 그만
                groupSize.add(arrayList.size());
                max = Math.max(arrayList.size(), max);
                arrayList.clear();
                while (visited[j-1] && j != length) {
                    System.out.println("j = " + j);
                    j++;
                }
                if (visited[j-1]) {
                    break;
                } else {
                    i = j;
                }
            } else {
                visited[i-1] = true;
                arrayList.add(i);
                i = cards[i-1];
                num++;
            }
            System.out.println("arrayList = " + arrayList);
        }

        answer *= max;
        int maxNext = 0;
        if (groupSize.size() != 1) {
            groupSize.remove((Integer) max);
            for (int k = 0; k < groupSize.size(); k++) {
                System.out.println("k = " + k);
                maxNext = Math.max(groupSize.get(k), maxNext);
            }
        }

        answer *= maxNext;


        System.out.println("answer = " + answer);
        return answer;
    }

    static void example(int cards[]) {
        int answer = 0;
        int length = cards.length;
        boolean[] visited = new boolean[length];
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            int now = i;
            int count = 0;
            while (!visited[now]) {
                count++;
                visited[now] = true;
                now = cards[now] - 1;
            }
            arrayList.add(count);
        }

        Collections.sort(arrayList);
        answer = arrayList.get(length-1) * arrayList.get(length-2);

        System.out.println("answer = " + answer);

    }
}
