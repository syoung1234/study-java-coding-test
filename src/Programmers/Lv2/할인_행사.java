package Programmers.Lv2;

import java.util.HashMap;
import java.util.Map;

public class 할인_행사 {
    public static void main(String[] args) {
        String[] want = {"banana"};
        int[] number = {3};
        String[] discount = {"banana", "banana", "banana", "banana", "chicken", "chicken", "chicken", "chicken", "chicken", "chicken"};
        solution(want, number, discount);
    }

    static int len;
    static Map<String, Integer> wantMap;
    static Map<String, Integer> discountMap;
    static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        len = number.length;
        wantMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            wantMap.put(want[i], number[i]);
        }

        int num = 0;
        while (num < discount.length) {
            discountMap = new HashMap<>();
            int length = num+10;
            if (discount.length < length) {
                length = discount.length;
            }
            for (int i = num; i < length; i++) {
                int quantity = discountMap.getOrDefault(discount[i], 0);
                discountMap.put(discount[i], quantity+1);
            }
            System.out.println("discountMap = " + discountMap);
            System.out.println("wantMap = " + wantMap);
            if (quantity(want)){
                answer++;
            } else {
                discountMap.put(discount[num], discountMap.get(discount[num])-1);
            }
            num++;
        }

        System.out.println("answer = " + answer);
        return answer;
    }

    static boolean quantity(String[] want) {
        boolean check = true;
        for (int i = 0; i < len; i++) {
            String w = want[i];
            int wantQ = wantMap.get(w);
            int discountQ = discountMap.getOrDefault(w, 0);
            if (wantQ > discountQ) {
                check = false;
                break;
            }
        }
        return check;
    }
}
