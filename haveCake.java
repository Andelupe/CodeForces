import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class haveCake {

    public static class result {
        boolean done;

        public result(boolean a) {
            done = a;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            long[][] cake = new long[3][N];
            long[][] pref = new long[3][N];
            long[] sum = new long[3];
            for (int j = 0; j < 3; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    int temp = Integer.parseInt(st.nextToken());
                    sum[j] += temp;
                    cake[j][k] = temp;
                    pref[j][k] = sum[j];
                }
            }
            double tot = sum[0];
            int[] indices = {0, 1, 2, 0, 2, 1, 1, 2, 0, 1, 0, 2, 2, 1, 0, 2, 0, 1};
            int curr = 0;
            result tempResult = new result(false);
            while (!tempResult.done && curr < 18) {
                twoPointers(N, pref, tot, tempResult, indices[curr], indices[curr + 1], indices[curr + 2]);
                curr += 3;
            }
            if (tempResult.done == false) {
                System.out.println(-1);
            }
        }
    }

    public static void twoPointers(int N, long[][] pref, double tot, result output, int first, int second, int third) {
        int left = 0, right = 1;
        double target = Math.ceil(tot / 3);
        while (left < N && right < N) {

            while (right < N - 1) {
                if (pref[first][left] >= target && pref[second][right] - pref[second][left] >= target && pref[third][N - 1] - pref[third][right] >= target) {
                    int[] indexes = new int[6];
                    if (first == 0) {
                        indexes[0] = 1;
                        indexes[1] = left + 1;
                    }
                    if (first == 1) {
                        indexes[2] = 1;
                        indexes[3] = left + 1;
                    }
                    if (first == 2) {
                        indexes[4] = 1;
                        indexes[5] = left + 1;
                    }
                    if (second == 0) {
                        indexes[0] = left + 2;
                        indexes[1] = right + 1;
                    }
                    if (second == 1) {
                        indexes[2] = left + 2;
                        indexes[3] = right + 1;
                    }
                    if (second == 2) {
                        indexes[4] = left + 2;
                        indexes[5] = right + 1;
                    }
                    if (third == 0) {
                        indexes[0] = right + 2;
                        indexes[1] = N;
                    }
                    if (third == 1) {
                        indexes[2] = right + 2;
                        indexes[3] = N;
                    }
                    if (third == 2) {
                        indexes[4] = right + 2;
                        indexes[5] = N;
                    }
                    for (int k = 0; k < 6; k++) {
                        System.out.print(indexes[k] + " ");
                        System.out.println();
                    }
                    output.done = true;
                    break;
                }
                if (pref[third][N - 1] - pref[third][right] < tot / 3) {
                    break;
                }
                if (pref[second][right] - pref[second][left] >= tot / 3) {
                    break;
                }
                right++;
            }
            if (output.done) {
                break;
            }
            left++;
        }
    }
}