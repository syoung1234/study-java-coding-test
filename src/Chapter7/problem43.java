package Chapter7;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class problem43 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        BufferedWriter bufferedWriter =  new BufferedWriter(new OutputStreamWriter(System.out));

        long n = gcd(a, b);

        for (long i = 0; i < n; i++) {
            bufferedWriter.write("1");
        }
        bufferedWriter.flush();

    }

    public static long gcd(long a, long b) {
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
