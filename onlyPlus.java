import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class onlyPlus {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int curr = 0;
            while (curr < 5) {
                int temp = Math.min(a, Math.min(b, c));
                curr++;
                if (a == temp) {
                    a++;
                    continue;
                }
                if (b == temp) {
                    b++;
                    continue;
                }
                if (c == temp) {
                    c++;
                    continue;
                }
            }
            System.out.println(a * b * c);
        }
    }
    
}
