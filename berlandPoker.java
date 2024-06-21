import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class berlandPoker {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int cPerson = N / K;
            int MaxJoker = Math.min(M, cPerson);
            int remaining = M - MaxJoker;
            int maxOther = (remaining + (K - 2)) / (K - 1);

            System.out.println(MaxJoker - maxOther);
        }
        br.close();
    }
}