import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cellularNetwork {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] cities = new int[N];
        int[] towers = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cities[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            towers[i] = Integer.parseInt(st.nextToken());
        }
        int currCit = 0;
        int currTow = 0;
        int rslt = 0;
        int curr = Integer.MAX_VALUE;
        while (currCit < N && currTow < M) {
            while (currTow < M) {
                if (curr < Math.abs(cities[currCit] - towers[currTow])) {
                    currTow--;
                    break;
                }
                curr = Math.abs(cities[currCit] - towers[currTow]);
                currTow++;
            }
            if (currTow == M) {
                currTow--;
            }
            rslt = Math.max(rslt, curr);
            currCit++;
            curr = Integer.MAX_VALUE;
        }
        System.out.println(rslt);
    }
}