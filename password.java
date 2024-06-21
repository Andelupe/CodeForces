import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class password {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine().trim());
            br.readLine();
            double temp = 10 - N;
            double rslt = (temp / 2) * (temp - 1) * 6;
            System.out.println((int) rslt);
        }

    }
}