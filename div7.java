import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class div7 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("div7.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("div7.out")));
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        int[] pref = new int[N];
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());
            temp %= 7;
            sum += temp;
            pref[i] = sum;
        }

        int rslt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = N - 1; j >= i + 1; j--) {
                int len = j - i;
                if ((pref[j] - pref[i]) % 7 == 0) {
                    rslt = Math.max(len, rslt);
                }
            }
        }

        out.println(rslt);
        out.close();
        br.close();
    }
    
}
