import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class angryMonk {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] arr = new int[K];
            int max = -1;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                int temp = Integer.parseInt(st.nextToken());
                max = Math.max(max, temp);
                arr[j] = temp;
            }
            int rslt = 0;
            boolean maxHit = false;
            for (int j = 0; j < K; j++) {
                if (arr[j] == max && !maxHit) {
                    maxHit = true;
                    continue;
                }
                if (arr[j] == 1) {
                    rslt++;
                    continue;
                }
                rslt += arr[j] * 2 - 1;
            }
            System.out.println(rslt);
        }
    }
    
}
