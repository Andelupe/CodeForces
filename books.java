import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class books {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[] books = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            books[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0, right = 0, curr = 0, rslt = 0;
        while (left < N && right < N) {
            while (right < N) {
                curr += books[right++];
                if (curr > T) {
                    curr -= books[--right];
                    break;
                }
            }
            rslt = Math.max(rslt, right - left);
            curr -= books[left++];
        }
        System.out.println(rslt);
    }
}