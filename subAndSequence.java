import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class subAndSequence {

    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < T; i++) {
            String sub = br.readLine().trim();
            String seq = br.readLine().trim();
            char[] baseline = new char[sub.length()];
            char[] adding = new char[seq.length()];
            for (int j = 0; j < baseline.length; j++) {
                baseline[j] = sub.charAt(j);
            }
            for (int j = 0; j < adding.length; j++) {
                adding[j] = seq.charAt(j);
            }

            int count = 0;
            for (int j = 0; j < adding.length; j++) {
                int curr = j;
                for (int k = 0; k < baseline.length; k++) {
                    if (curr == adding.length) {
                        break;
                    }
                    if (baseline[k] == adding[curr]) {
                        curr++;
                    }
                }
                count = Math.max(count, curr - j);
            }
            System.out.println(baseline.length + adding.length - count);
        }
    }
}