package Programmers.Lv1;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/159994
 */
public class 카드_뭉치 {
    public static void main(String[] args) {
        String[] cards1 = {"i", "water", "drink"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};

        solution(cards1, cards2, goal);
    }

    static String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        int one = 0;
        int two = 0;

        for (String s : goal) {
            if (one < cards1.length && cards1[one].equals(s)) {
                one++;
            } else if (two < cards2.length && cards2[two].equals(s)) {
                two++;
            } else {
                answer = "No";
                break;
            }
        }

        System.out.println("answer = " + answer);

        return answer;
    }
}
