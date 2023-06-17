package Programmers.Lv1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

/****
 * 프로그래머스
 * https://school.programmers.co.kr/learn/courses/30/lessons/150370
 */

public class 개인정보_수집_유효기간 {
    public static void main(String[] args) {
        int[] array1 = {2, 4};
        int length = array1.length;
        String[][] array = new String[length][length];

        String[] terms = {"A 6", "B 12", "C 3"};
        String [] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        solution("2022.05.19", terms, privacies);

    }

    static int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        ArrayList<TypeTerm> arrayList = new ArrayList<TypeTerm>();
        int arrayCount = 0;
        int[] result = new int [privacies.length+1];

        for (int i = 0; i < terms.length; i++) {
            String[] s = terms[i].split(" ");
            arrayList.add(new TypeTerm(s[0], Integer.parseInt(s[1])));
        }

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate todayDate = LocalDate.parse(today, dateTimeFormatter);

        for (int i = 0; i < privacies.length; i++) {
            String[] s = privacies[i].split(" ");
            LocalDate date = LocalDate.parse(s[0], dateTimeFormatter);
            // String type = s[1];
            int month = 0;

            // 유형 - 달 찾기
            for (TypeTerm t : arrayList) {
                if (t.type.equals(s[1])) {
                    month = t.month;
                    break;
                }
            }

            // 비교
            LocalDate privacyDate = date.plusMonths(month);
            System.out.println(privacyDate.getDayOfMonth());

            if (privacyDate.getDayOfMonth() > 28) {

                int day = privacyDate.getDayOfMonth();
                while (day > 28) {
                    day--;
                    privacyDate = privacyDate.minusDays(1);
                }

            }
            System.out.println("privacyDate = " + privacyDate);
            if (todayDate.isBefore(privacyDate)) {

                System.out.println("todayDate = " + todayDate.isBefore(privacyDate));
            } else {
                result[arrayCount] = i+1;
                arrayCount++;

                System.out.println("todayDate = " + todayDate.isBefore(privacyDate));
                System.out.println("result = " + result[arrayCount]);
            }

        }

        int index = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i] == 0) {
                index = i;
                break;
            }
        }

        answer = Arrays.copyOfRange(result, 0, index);

        System.out.println("Arrays.toString(answer) = " + Arrays.toString(answer));

        return answer;
    }

    public static class TypeTerm {
        private String type;
        private int month;


        public  TypeTerm(String type, int month) {
            this.type = type;
            this.month = month;
        }
    }
}
