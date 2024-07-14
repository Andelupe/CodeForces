import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class catchCoin {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            if (Y < -1) {
                System.out.println("NO");
                continue;
            }
            System.out.println("YES");
        }
        
    }
    
}
