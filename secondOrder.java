import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class secondOrder {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int min = Integer.MAX_VALUE;
        int rslt = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (min == Integer.MAX_VALUE) {
                min = Math.min(min, temp);
                continue;
            }
            if (temp == min) continue;
            if (temp < min) {
                rslt = Math.min(min, rslt);
            } else {
                rslt = Math.min(temp, rslt);
            }
            
            min = Math.min(min, temp);
        }

        if (rslt == Integer.MAX_VALUE) {
            System.out.println("NO");
        } else {
            System.out.println(rslt);
        }

        br.close();
    }
}





