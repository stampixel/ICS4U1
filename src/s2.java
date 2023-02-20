import java.util.*;
import java.io.*;
public class s2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n = readInt(), mountains[] = new int[n];

        for(int i = 0; i < n; i ++) {
            mountains[i] = readInt();
        }

        int[] asy_values = new int[n];

        for (int i = 0; i < mountains.length; i ++) {
            List<Integer> tmp=new ArrayList<Integer>();
            for (int j = 0; j < mountains.length-i; j ++) {

            }
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
