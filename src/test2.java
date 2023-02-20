import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] mountains = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            mountains[i] = Integer.parseInt(st.nextToken());
        }

        int[] asy_values = new int[n];
        int crop_value = 1;
        for (int i = 0; i < mountains.length; i++) {
            int[] tmp = new int[mountains.length - i];
            int len = i + 1;
            for (int j = 0; j < tmp.length; j++) {
                int sum1 = 0;
                for (int k = 0; k < len / 2; k++) {
                    sum1 += Math.abs(mountains[j+k] - mountains[j+len-1-k]);
                }
                tmp[j] = sum1;
            }
            asy_values[i] = min(tmp);
        }

        for (int value : asy_values) {
            System.out.print(value + " ");
        }
    }

    public static int min(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int value : arr) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }
}
