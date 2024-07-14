import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class testoflove {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            String test = br.readLine().trim();
            test = "L" + test + "L";
            int currDist = 0;
            boolean bad = false;
            boolean swim = false;
            boolean jumping = false;
            for (int j = 0; j <= N + 1; j++) {
                if (currDist > M) {
                    if (jumping) {
                        currDist = j - M;
                        j--;
                        jumping = false;
                    }
                    swim = true;
                }
                if (currDist > M && (test.charAt(j - 1) == 'C' || currDist - 1 > K)) {
                    System.out.println("NO");
                    bad = true;
                    break;
                }
                if (test.charAt(j) == 'L') {
                    if (swim) {
                        K -= (currDist - 1);
                        if (K < 0) {
                            System.out.println("NO");
                            bad = true;
                            break;
                        }
                    }
                    swim = false;
                    currDist = 0;
                    jumping = true;
                }

                currDist++;
            }
            if (!bad) {
                System.out.println("YES");
            }
        }
    }
}