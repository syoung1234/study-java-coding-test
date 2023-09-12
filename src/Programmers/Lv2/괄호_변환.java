package Programmers.Lv2;


import java.util.Objects;

/**
 * 프로그래머스
 * https://school.programmers.co.kr/learn/courses/30/lessons/60058
 */
public class 괄호_변환 {
    public static void main(String[] args) {
        solution("()))((()");
    }

    static String answer = "";
    static String solution(String p) {
        divideStr(p);
        System.out.println("answer = " + answer);
        return answer;
    }

    static String divideStr(String p) {
        char[] array = p.toCharArray();
        int left = 0;
        int right = 0;
        String u = "";
        String v = "";
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                u = p.substring(0, i+1);
                v = p.substring(i+1, array.length);
                break;
            }
        }



        return checkU(u, v);

    }

    static String checkU(String u, String v) {
        if (Objects.equals(u, "")) {
            return "";
        }
        // 올바를 때
        if (u.charAt(0) == '(') {
            // v에 대해 수행
            System.out.println("올바름:"+u);
            if (v.length() > 0) {
                u += divideStr(v);
            }
            System.out.println("올바름 변경후 :"+u);
            answer = u;
            return u;
        } else { // 올바르지 않음
            String newStr = "(" + divideStr(v) + ")";

            // 뒤집기
            System.out.println("자르기:"+u.substring(1, u.length()-1));
            newStr += reverseU(u.substring(1, u.length()-1));
            System.out.println("새로운:"+newStr);
            answer = newStr;
            return newStr;
        }


    }

    static String reverseU(String u) {
        char[] charArr = u.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == '(') {
                charArr[i] = ')';
            } else {
                charArr[i] = '(';
            }
        }
        System.out.println("re=" + String.valueOf(charArr));
        return String.valueOf(charArr);
    }
}
