import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class flipGame {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        int[] pref = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            sum += a;
            arr[i] = a;
            pref[i] = sum;
        }

        int flips = 0;
        int maxFlips = -1;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                if (arr[j] == 0) {
                    flips++;
                } else {
                    flips--;
                }
                int rslt = (i == 0) ? 0 : pref[i - 1];
                rslt += (i == 0) ? pref[N - 1] : pref[N - 1] - pref[i - 1];
                rslt += flips;

                maxFlips = Math.max(rslt, maxFlips);
            }
            flips = 0;
        }

        System.out.println(maxFlips);
        br.close();
    }
}