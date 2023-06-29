package Programmers.Lv2;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/172927
 */
public class 광물_캐기 {
    public static void main(String[] args) {
        int[] picks = {0, 1, 1}; // dia, iron, stone
        String[] minerals = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};
        solution(picks, minerals);
    }

    static int solution(int[] picks, String[] minerals) {
        int answer = 0;
        ArrayList<FiveMinerals> arrayList = new ArrayList<>();
        int dia = 0, iron = 0, stone = 0;
        int picksCount = picks[0] + picks[1] + picks[2];
        int r = minerals.length % 5 == 0 ? 0 : 1;
        int length = minerals.length;

        // 곡괭이가 부족하다면
        if (picksCount < minerals.length / 5 + r) {
            length = picksCount * 5;
        }
        int i;
        for (i = 0; i < length; i++) {
            if (minerals[i].equals("diamond")) {
                dia++;
            } else if (minerals[i].equals("iron")) {
                iron++;
            } else {
                stone++;
            }
            if ((i+1) % 5 == 0) {
                arrayList.add(new FiveMinerals(dia, iron, stone));
                dia = 0; iron = 0; stone = 0;
            }
        }
        if (i % 5 != 0) {
            arrayList.add(new FiveMinerals(dia, iron, stone));
        }

        arrayList.sort(new FiveMineralsComparator());

        int num = 0;

        while (num != arrayList.size()) {
            FiveMinerals fiveMinerals = arrayList.get(num);
            if (picks[0] > 0) { // 다이아몬드 곡괭이
                answer += fiveMinerals.dia + fiveMinerals.iron + fiveMinerals.stone;
                picks[0]--;
            } else if (picks[1] > 0) { // 철 곡괭이
                answer += (fiveMinerals.dia * 5) + fiveMinerals.iron + fiveMinerals.stone;
                picks[1]--;
            } else { // 돌 곡괭이
                answer += (fiveMinerals.dia * 25) + (fiveMinerals.iron * 5) + fiveMinerals.stone;
                picks[2]--;
            }
            num++;
        }

        System.out.println("answer = " + answer);

        return answer;
    }

    static class FiveMinerals {
        private int dia;
        private int iron;
        private int stone;

        public FiveMinerals(int dia, int iron, int stone) {
            this.dia = dia;
            this.iron = iron;
            this.stone = stone;
        }
    }

    static class FiveMineralsComparator implements Comparator<FiveMinerals> {
        @Override
        public int compare(FiveMinerals o1, FiveMinerals o2) {
            if (o1.dia < o2.dia) return 1;
            if (o1.dia > o2.dia) return -1;
            else {
                if (o1.iron < o2.iron) return 1;
                if (o1.iron > o2.iron) return -1;
                else {
                    if (o1.stone < o2.stone) return 1;
                    if (o1.stone > o2.stone) return -1;
                }
            }
            return 0;
        }
    }
}
