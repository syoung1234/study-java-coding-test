package Programmers.Lv1;

/**
 * 프로그래머스
 * https://school.programmers.co.kr/learn/courses/30/lessons/72410
 */
public class 신규_아이디_추천 {
    public static void main(String[] args) {
        solution(".b.....");
    }

    static String solution(String new_id) {
        String answer = new_id;

        int length = new_id.length();

        // 1. 대문자 -> 소문자
        answer = answer.toLowerCase();

        // 2. 특수문자 제거
        answer = answer.replaceAll("[~!@#$%^&*()=+\\['{\\]'}:?,<>/]", "");

        // 3. ... 연속될 경우 . 한 개로 치환
        answer = answer.replaceAll("\\.{2,}", ".");


        // 4. 맨 앞뒤 . 제거
        answer = answer.replaceAll("[.]$", "");
        answer = answer.replaceAll("^[.]", "");

        System.out.println("answer = " + answer);

        // 5. 빈문자열일 경우 a 대입
        answer = answer.equals("") ? "a" : answer;

        // 6. 15개로 자르기, 맨 뒤 마침표라면 제거
        answer = answer.length() > 15 ? answer.substring(0,15) : answer;
        answer = answer.replaceAll("[.]$", "");

        // 7. 최소 3자
        if (answer.length() < 3) {
            int end = answer.length()-1;
            StringBuilder stringBuilder = new StringBuilder();
            char c = answer.charAt(end);
            stringBuilder.append(answer);
            while (answer.length() < 3) {
                stringBuilder.append(c);
                answer = stringBuilder.toString();
            }
        }

        System.out.println("answer = " + answer);


        return answer;
    }
}
