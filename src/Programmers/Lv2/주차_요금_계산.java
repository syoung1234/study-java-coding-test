package Programmers.Lv2;

import java.util.*;
import java.util.stream.Stream;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/92341
 */
public class 주차_요금_계산 {
    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        solution(fees, records);
    }
    static ArrayList<Integer> solution(int[] fees, String[] records) {
        ArrayList<Integer> answer = new ArrayList<>();
        Map<String, Integer> inMap = new HashMap<>();
        Map<String, Integer> outMap = new HashMap<>();

        // s[0] = 시간, s[1] = 차 번호, s[3] = 입/출차 시간
        for (String record : records) {
            String[] s = record.split(" ");
            if (s[2].equals("IN")) {
                inMap.put(s[1], convertTime(s[0]));
            } else {
                int outIn = convertTime(s[0]) - inMap.get(s[1]);
                int accumulate = outMap.getOrDefault(s[1], 0);
                outMap.put(s[1], accumulate + outIn);
                inMap.remove(s[1]);
            }
        }

        // 23:59분 출차
        int last = convertTime("23:59");
        for (String key : inMap.keySet()) {
            int outIn = last - inMap.get(key);
            int accumulate = outMap.getOrDefault(key, 0);
            outMap.put(key, accumulate + outIn);
            // inMap.remove(key);  <- ConcurrentModificationException 발생할 수 있음, 제거할 필요 없음! 제거하면 index가 바뀜
        }

        List<String> keySet = new ArrayList<>(outMap.keySet());

        // 키 값으로 오름차순 정렬
        Collections.sort(keySet);

        // 기본 시간=fees[0], 기본 요금=fees[1], 단위 시간=fees[2], 단위 요금=fees[3]
        for (int i = 0; i < outMap.size(); i++) {
            int time = outMap.get(keySet.get(i));
            if (time <= fees[0]) { // 기본 시간보다 작음
                answer.add(fees[1]);
            } else {
                double a = time - fees[0];
                double b = Math.ceil(a / fees[2]);
                int result = (int) (b * fees[3] + fees[1]);
                answer.add(result);
            }
        }

        System.out.println("inMap = " + inMap);
        System.out.println("outMap = " + outMap);
        System.out.println("answer = " + answer);
        return answer;
    }

    static int convertTime(String time) {
        String[] s = time.split(":");
        int hour = Integer.parseInt(s[0]);
        int minute = Integer.parseInt(s[1]);

        return hour * 60 + minute;
    }

}
