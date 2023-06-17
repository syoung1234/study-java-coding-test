package Programmers.Lv1;

import java.util.Arrays;

public class 바탕화면_정리 {
    public static void main(String[] args) {
        String[] wallpaper = {"..........", ".....#....", "......##..", "...##.....", "....#....."};
        solution(wallpaper);

    }

    public static int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int minX = 51;
        int maxX = 0;
        int minY = 51;
        int maxY = 0;

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                String s = wallpaper[i].substring(j, j+1);
                if (s.equals("#")) {
                    maxX = Math.max(maxX, i);
                    minX = Math.min(minX, i);
                    maxY = Math.max(maxY, j);
                    minY = Math.min(minY, j);
                }
            }
        }

        // left 값: x 최소값, y 최대값
        // right: x최대값+1, y최소값+1

        answer[0] = minX;
        answer[1] = minY;
        answer[2] = ++maxX;
        answer[3] = ++maxY;


        System.out.println("answer = " + Arrays.toString(answer));
        return answer;
    }
}
