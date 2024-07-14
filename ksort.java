import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ksort {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine().trim());
            st = new StringTokenizer(br.readLine());
            
            Long[] arr = new Long[N];
            for (int j = 0; j < N; j++) {
                arr[j] = Long.parseLong(st.nextToken());
            }

            ArrayList<Long> sums = new ArrayList<>();
            long prevHi = 0;
            for (int j = 0; j < N; j++) {
                prevHi = Math.max(prevHi, arr[j]);
                if (prevHi > arr[j]) {
                    sums.add(prevHi - arr[j]);
                }
            }

            Collections.sort(sums);
            long curr = 0;
            long rslt = 0;
            for (int j = 0; j < sums.size(); j++) {
                rslt += (sums.size() - j + 1) * (sums.get(j) - curr);
                curr = sums.get(j);
            }
            System.out.println(rslt);
        }
    }
}