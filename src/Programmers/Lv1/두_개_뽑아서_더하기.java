package Programmers.Lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 프로그래머스
 * https://school.programmers.co.kr/learn/courses/30/lessons/68644
 */
public class 두_개_뽑아서_더하기 {
    public static void main(String[] args) {
        int[] numbers = {2,1,3,4,1,};
        solution(numbers);
    }

    static Object[] solution(int[] numbers) {
        int[] answer = {};
        ArrayList<Integer> arrayList = new ArrayList<>();
        
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                arrayList.add(numbers[i]+ numbers[j]);
            }
        }

        Collections.sort(arrayList);
        Object[] list = arrayList.stream().distinct().toArray();

        System.out.println("list = " + Arrays.toString(list));

        return list;
    }
}
