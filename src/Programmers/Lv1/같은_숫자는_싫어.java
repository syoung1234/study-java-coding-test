package Programmers.Lv1;

import java.util.ArrayList;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12906
 */
public class 같은_숫자는_싫어 {
    public static void main(String[] args) {
        int[] arr = {1,1,3,3,0,1,1};
        solution(arr);
    }

    static ArrayList<Integer> solution(int []arr) {
        int[] answer = {};

        ArrayList<Integer> arrayList = new ArrayList<>();
        int start = arr[0];
        arrayList.add(start);
        for (int i = 1; i < arr.length; i++) {
            if (start != arr[i]) {
                arrayList.add(arr[i]);
                start = arr[i];
            }
        }
        System.out.println("arrayList = " + arrayList);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return arrayList;
    }
}
