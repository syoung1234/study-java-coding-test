package Programmers.Lv2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 프로그래머스
 * https://school.programmers.co.kr/learn/courses/30/lessons/17686
 */
public class 파일명_정렬 {
    public static void main(String[] args) {
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        solution(files);
    }

    static String[] solution(String[] files) {
        String[] answer = {};
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String head1 = findString(o1);
                String head2 = findString(o2);

                int com = head1.compareToIgnoreCase(head2);

                if (com == 0) { // 같은 문자열일 때, NUMBER 비교
                    return findNumber(o1) - findNumber(o2);
                } else {
                    return com;
                }
            }
        });

        System.out.println(Arrays.toString(files));
        return files;
    }

    static String findString(String str) {
        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                break;
            }
            result.append(c);
        }

        return String.valueOf(result);
    }

    static int findNumber(String str) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group());
        } else {
            return 0;
        }

    }
}
