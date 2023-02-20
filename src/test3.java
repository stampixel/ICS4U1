import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class test3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = readInt();
        int[] mountains = new int[n];
        for (int i = 0; i < n; i++) {
            mountains[i] = readInt();
        }

        int[] asy_values = new int[n];
        int crop_value = 1;
        for (int i = 0; i < mountains.length; i++) {
            int min_sum = Integer.MAX_VALUE;
            for (int j = 0; j < mountains.length - i; j++) {
                int[] substring = Arrays.copyOfRange(mountains, j, i+j+1);

                int sum1 = 0;
                for (int k = 0; k < substring.length / 2; k++) {
                    sum1 += Math.abs(substring[k] - substring[substring.length-1-k]);
                }
                if (sum1 < min_sum) {
                    min_sum = sum1;
                }
            }
            asy_values[i] = min_sum;
        }

        for (int value : asy_values) {
            System.out.print(value + " ");
        }
    }

    static String next () throws IOException {
        while (st == null || ! st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static long readLong () throws IOException {
        return Long.parseLong(next());
    }

    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }

    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }

    static char readCharacter () throws IOException {
        return next().charAt(0);
    }

    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}
