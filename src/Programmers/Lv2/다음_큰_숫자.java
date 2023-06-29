package Programmers.Lv2;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12911
 * replaceAll 보다 toCharArray 가 더 빠름
 * replaceAll 했을 때 프로그래머스 효율성 0점 나옴
 */
public class 다음_큰_숫자 {
    public static void main(String[] args) {
        solution(15);
    }

    static int solution(int n) {
        int answer = 0;

        // 2진수 변환
        String str = Integer.toBinaryString(n);

        // 1 개수
        int oneCount = countOne(str);

        while (true) {
            n++;
            String bigNum = Integer.toBinaryString(n);
            int bigOneCount = countOne(bigNum);
            if (oneCount == bigOneCount) {
                break;
            }
        }

        return n;
    }

    private static int countOne(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }
        return count;
    }
}
