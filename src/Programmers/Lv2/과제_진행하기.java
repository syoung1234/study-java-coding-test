package Programmers.Lv2;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/176962
 */
public class 과제_진행하기 {
    public static void main(String[] args) {
//        String[][] plans = {
//                {"science", "12:40", "50"}, {"music", "12:20", "40"},
//                {"history", "14:00", "30"}, {"computer", "12:30", "100"}
//        };
        String[][] plans = {
                {"A", "00:00", "30"}, {"B", "00:10", "10"},
                {"C", "00:30", "10"}, {"D", "00:50", "10"}
        };
        solution(plans);
    }

    static ArrayList<String> solution(String[][] plans) {
        String[] answer = {};
        ArrayList<String> arrayList = new ArrayList<>();

        // 시간순 정렬
        Arrays.sort(plans, Comparator.comparing(o -> o[1]));
        Stack<Task> stack = new Stack<>();

        String currentSubject = plans[0][0];
        String currentStart = plans[0][1];
        int currentTime = Integer.parseInt(plans[0][2]);

        for (int i = 1; i < plans.length; i++) {
            String nextSubject = plans[i][0];
            String nextStart = plans[i][1];
            int nextTime = Integer.parseInt(plans[i][2]);

            int gap = currentTime - minusTime(currentStart, nextStart) ; // 차이 12:30 - 12:20 = 10분 , 40분-10분 = 30분

            if (gap == 0) { // 깔끔하게 끝
                arrayList.add(currentSubject);
            } else if (gap < 0) { // 남은 시간이 있음, 이전 과제 수행
                arrayList.add(currentSubject);
                while(!stack.isEmpty() && gap < 0) {
                    Task task = stack.pop();
                    gap = task.time + gap;
                    if (gap == 0) {
                        arrayList.add(task.subject);
                    } else if (gap > 0) {
                        // 다시 push
                        stack.push(new Task(task.subject, task.start, gap));
                    } else {
                        // 다음것도 수행
                        arrayList.add(task.subject);
                    }
                }
            } else { // 완료까지 시간이 모자람
                stack.push(new Task(currentSubject, currentStart, gap));
            }
            currentSubject = nextSubject;
            currentStart = nextStart;
            currentTime = nextTime;
        }

        arrayList.add(plans[plans.length-1][0]);

        while (!stack.isEmpty()) {
            Task task = stack.pop();
            arrayList.add(task.subject);
        }

        System.out.println("arrayList = " + arrayList);
        return arrayList;
    }

    private static int minusTime(String current, String next) {
        String[] cArr = current.split(":");
        String[] nArr = next.split(":");
        int cHour = Integer.parseInt(cArr[0]);
        int nHour = Integer.parseInt(nArr[0]);

        int c = Integer.parseInt(cArr[1]);
        int n = Integer.parseInt(nArr[1]);

        return (nHour * 60 + n) - (cHour * 60 + c);
    }

    static class Task {
        private String subject;
        private String start;
        private int time;

        public Task(String subject, String start, int time) {
            this.subject = subject;
            this.start = start;
            this.time = time;
        }
    }


}
