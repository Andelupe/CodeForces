import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pouring {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double d = Double.parseDouble(st.nextToken());
        double h = Double.parseDouble(st.nextToken());
        double v = Double.parseDouble(st.nextToken());
        double e = Double.parseDouble(st.nextToken());
        double inc = Math.PI * Math.pow((d / 2), 2) * e;
        double vol = Math.PI * Math.pow((d / 2), 2) * h;
        if (h == 0 || d == 0) {
            System.out.println("YES");
            System.out.println(0);
        } else if (inc > v) {
            System.out.println("NO");
        } else if (inc == v) {
            System.out.println("NO");
        } else {
            double rslt = vol / (v - inc);
            System.out.println("YES");
            System.out.println(rslt);
        }
    }
}