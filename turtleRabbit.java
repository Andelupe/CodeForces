import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class turtleRabbit {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine().trim());
            int[] tracks = new int[N];
            int[] pref = new int[N];
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int temp1 = Integer.parseInt(st.nextToken());
                sum += temp1;
                tracks[j] = temp1;
                pref[j] = sum;
            }
            int Q = Integer.parseInt(br.readLine().trim());
            for (int j = 0; j < Q; j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int maxVal = Integer.parseInt(st.nextToken());
                int rslt = -1;
                int prevScore = Integer.MIN_VALUE;
                for (int k = start; k < N; k++) {
                    int sub = (start == 1) ? 0 : pref[start - 1];
                    int temp = pref[k - 1] - sub;
                    int score = gauss(maxVal - temp + 1, maxVal);
                    if (score <= prevScore) {
                        break;
                    } else {
                        rslt = k;
                        prevScore = score;
                    }
                }
                if (rslt == -1) {
                    System.out.print(start + " ");
                } else {
                    System.out.print(rslt + " ");
                }
            }
            System.out.println();
        }
    }

    public static int gauss(int x, int y) {
        if (x > y) {
            int temp = x;
            x = y;
            y = temp;
        }

        int n = y - x + 1;
        int totalSum = n * (x + y) / 2;
        return totalSum;
    }
}