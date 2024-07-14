import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class smithing {

    public static class weapon {
        int in, out, diff;

        public weapon(int a, int b, int c) {
            in = a;
            out = b;
            diff = c;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] in = new int[N];
        int[] out = new int[N];
        weapon[] smiths = new weapon[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            in[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            out[i] = Integer.parseInt(st.nextToken());
            weapon temp = new weapon(in[i], out[i], in[i] - out[i]);
            smiths[i] = temp;
        }

        st = new StringTokenizer(br.readLine());
        int[] stock = new int[M];
        for (int i = 0; i < N; i++) {
            stock[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(smiths, (a, b) -> a.diff - b.diff);
        for (int i = 0; i < M; i++) {
            
        }
    }
}