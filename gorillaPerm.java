import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class gorillaPerm {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] rslt = new int[N];
            int curr = 0;
            for (int j = N; j >= K; j--) {
                rslt[curr] = j;
                curr++;
            }
            for (int j = K - 1; j > M; j--) {
                rslt[curr] = j;
                curr++;
            }
            for (int j = 1; j <= M; j++) {
                rslt[curr] = j;
                curr++;
            }
            for (int j = 0; j < N; j++) {
                System.out.print(rslt[j] + " ");
            }
            System.out.println();
        }
    }
    
}
