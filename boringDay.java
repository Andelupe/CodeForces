import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boringDay {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            long[] prefSum = new long[N];
            long sum = 0;
            int[] cards = new int[N];
            for (int j = 0; j < N; j++) {
                cards[j] = Integer.parseInt(st.nextToken());
                sum += cards[j];
                prefSum[j] = sum;
            }


            int rslt = 0;
            
            for (int j = 0; j < N; j++) {
                if (cards[j] > R) {
                    continue;
                }
                if (cards[j] >= L && cards[j] <= R) {
                    rslt++;
                } else {
                    int index = -1;
                    for (int k = j + 1; k < N; k++) {
                        long temp = (j == 0) ? prefSum[k] : prefSum[k] - prefSum[j - 1];
                        if (temp > R) {
                            break;
                         }
                        if (temp >= L && temp <= R) {
                            rslt++;
                            index = k;
                            break;
                        }
                    }
                    if (index == N - 1) {
                        break;
                    }
                    if (index == -1) {
                        continue;
                    }
                    j = index + 1;
                }
            }
            System.out.println(rslt);
        }
    }
    
}
