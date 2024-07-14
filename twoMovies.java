import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class twoMovies {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            int[][] movies = new int[N][2];
            st = new StringTokenizer(br.readLine());
            int r1 = 0;
            int r2 = 0;
            int add = 0;
            int sub = 0;
            
            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                movies[j][0] = temp;
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                movies[j][1] = temp;
                if (temp < 1 && movies[j][0] == 1) {
                    r1++;
                }
                if (temp == 1 && movies[j][0] < 1) {
                    r2++;
                }
                if (temp == 1 && movies[j][0] == 1) {
                    add++;
                }
                if (temp == -1 && movies[j][0] == -1) {
                    sub++;
                }
            }
            while (add > 0) {
                if (r1 < r2) {
                    r1++;
                } else {
                    r2++;
                }
                add--;
            }
            while (sub > 0) {
                if (r1 < r2) {
                    r2--;
                } else {
                    r1--;
                }
                sub--;
            }

            System.out.println(Math.min(r1, r2));
        }
    }
}