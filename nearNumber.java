import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class nearNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine().trim();
        int sum = 0; 
        int b = 0;
        while (1 > 0) {
            for (int i = 0; i < a.length(); i++) {
                sum += Integer.parseInt(a.substring(i, i + 1));
            }
            if (sum % 4 == 0) {
                b = Integer.parseInt(a);
                break;
            } else {
                b = Integer.parseInt(a);
                b++;
                a = Integer.toString(b);
            }
            sum = 0;
        }
        System.out.println(b);
        br.close();
    }
}