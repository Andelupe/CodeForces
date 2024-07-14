import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class soccer {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            boolean rslt = false;
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            if (a > b) {
                if (c > d) {
                    rslt = true;
                }
            } else if (b > a) {
                if (d > c) {
                    rslt = true;
                }
            } else {
                if (c == d) {
                    rslt = false;
                } else {
                    rslt = true;
                }
            }
            if (rslt) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
    
}
