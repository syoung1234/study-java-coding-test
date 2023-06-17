package Programmers.Lv1;

public class 크기가_작은_부분_문자열 {
    public static void main(String[] args) {
        solution("10000000000", "10000000000");
    }

    public static int solution(String t, String p) {
        int answer = 0;

        int leftIndex = 0;
        int rightIndex = p.length();
        Long pNum = Long.parseLong(p);

        while (rightIndex != t.length() + 1) {
            String s = t.substring(leftIndex, rightIndex);
            System.out.println("s = " + s);
            Long tNum = Long.parseLong(s);

            if (tNum <= pNum) {
                answer++;
            }
            leftIndex++;
            rightIndex++;
        }

        System.out.println("answer = " + answer);
        return answer;
    }
}
