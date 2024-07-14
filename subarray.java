import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class subarray {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long[] pref = new long[N + 1];
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < N + 1; i++) {
            pref[i] = pref[i - 1] + arr[i - 1];
        }

        int rslt = 0;
        for (int i = 0; i < N + 1; i++) {
            
        }
        System.out.println(rslt);
    }
}