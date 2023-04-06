package Chapter6;

import java.util.Scanner;

public class problem36 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strArray = str.split("-");
        int result = 0;

        for (int i = 0; i < strArray.length; i++) {
            String[] plusArray = strArray[i].split("\\+");
            int temp = 0;

            for (int j = 0; j < plusArray.length; j++) {
                temp += Integer.parseInt(plusArray[j]);
            }

            if (i == 0) {
                result += temp;
            } else {
                result -= temp;
            }


        }

        System.out.println(result);

        // 100-40+50+74-30+29-45+43+11

    }
}
