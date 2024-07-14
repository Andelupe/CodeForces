import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class arrayDiv {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            for (int j = 1; j <= N; j++) {
                long curr = 1;
                ArrayList<Long> factors = new ArrayList<>();
                while (curr <= j) {
                    if (j % curr == 0) {
                        factors.add(curr);
                    }
                    curr++;
                }
                long rslt = 1;
                for (int k = 0; k < factors.size(); k++) {
                    if (rslt % factors.get(k) == 0) {
                        continue;
                    }
                    rslt *= factors.get(k);
                }
                System.out.print(rslt + " ");
            }
        }
    }
    
}
