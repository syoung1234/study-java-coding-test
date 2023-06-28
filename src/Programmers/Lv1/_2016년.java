package Programmers.Lv1;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12901
 */
public class _2016년 {
    public static void main(String[] args) {
        solution(5, 24);
    }

    static String solution(int a, int b) {
        String answer = "";

        LocalDate localDate = LocalDate.of(2016, a, b);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        answer = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.US).toUpperCase(Locale.ROOT);

        return answer;
    }
}
