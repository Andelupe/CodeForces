import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class collatz {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        StringBuilder rslt = new StringBuilder();

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            
            while (1 > 0) {
                int remainder = (x / y + 1) * y;

                if (x == 1) {
                    break;
                }

                if (remainder - x > k) {
                    x += k;
                    k = 0;
                    break;
                }

                k -= remainder - x;
                x = remainder;

                while (x % y == 0) {
                    x /= y;
                }
            }
            rslt.append(x + k % (y - 1) + "\n");
        }

        System.out.print(rslt.toString());
    }
}