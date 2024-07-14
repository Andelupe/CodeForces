import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class clock {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            String[] time = st.nextToken().split(":");
            int incr = Integer.parseInt(st.nextToken());
            int minStart = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            HashSet<Integer> mins = new HashSet<>();
            int curr = minStart;
            while (!mins.contains(curr)) {
                mins.add(curr);
                curr += incr;
                curr %= 1440;
            }
            int rslt = 0;
            if (mins.contains(0)) {
                rslt++;
            }
            if (mins.contains(70)) {
                rslt++;
            }
            if (mins.contains(140)) {
                rslt++;
            }
            if (mins.contains(210)) {
                rslt++;
            }
            if (mins.contains(280)) {
                rslt++;
            }
            if (mins.contains(350)) {
                rslt++;
            }
            if (mins.contains(601)) {
                rslt++;
            }
            if (mins.contains(671)) {
                rslt++;
            }
            if (mins.contains(741)) {
                rslt++;
            }
            if (mins.contains(811)) {
                rslt++;
            }
            if (mins.contains(881)) {
                rslt++;
            }
            if (mins.contains(951)) {
                rslt++;
            }
            if (mins.contains(1202)) {
                rslt++;
            }
            if (mins.contains(1272)) {
                rslt++;
            }
            if (mins.contains(1342)) {
                rslt++;
            }
            if (mins.contains(1412)) {
                rslt++;
            }
            System.out.println(rslt);
        }
    }
}