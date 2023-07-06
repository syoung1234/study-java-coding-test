package Programmers.Lv2;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43165
 * DFS
 */
public class 타켓_넘버 {
    public static void main(String[] args) {
        int[] numbers = {4, 1, 2, 1};
        int target = 4;
        solution(numbers, target);
    }

    static int solution(int[] numbers, int target) {
        return DFS(numbers,target, 0 ,0);
    }

    static int DFS(int[] numbers, int target, int sum, int depth) {

        if (depth == numbers.length) {
            System.out.println("depth = " + depth);
            if (target == sum) {
                return 1;
            }
            return 0;
        }

        return DFS(numbers, target,sum + numbers[depth], depth + 1) + DFS(numbers, target, sum - numbers[depth], depth + 1);

    }
}
