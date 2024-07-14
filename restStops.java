import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class restStops {

    public static class Stop implements Comparable<Stop> {
        long x; long taste;

        public Stop(long a, long b) {
            x = a;
            taste = b;
        }

        public int compareTo(Stop s) {
            return -Long.compare(taste, s.taste);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("reststops.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("reststops.out")));
        Long.parseLong(st.nextToken());
        long N = Long.parseLong(st.nextToken());
        long farmerSpeed = Long.parseLong(st.nextToken());
        long bessieSpeed = Long.parseLong(st.nextToken());
        List<Stop> stops = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long temp1 = Long.parseLong(st.nextToken());
            long temp2 = Long.parseLong(st.nextToken());
            Stop tempStop = new Stop(temp1, temp2);
            stops.add(tempStop);
        }

        Collections.sort(stops);
        List<Stop> validStops = new ArrayList<>();
        long currPos = -1;
        for (int i = 0; i < N; i++) {
            if (stops.get(i).x > currPos) {
                validStops.add(stops.get(i));
                currPos = stops.get(i).x;
            }
        }

        long testPos = 0;
        BigInteger rslt = new BigInteger("0");
        for (int i = 0; i < validStops.size(); i++) {
            long temp1 = validStops.get(i).x - testPos;
            long temp2 = farmerSpeed - bessieSpeed;
            BigInteger a = BigInteger.valueOf(temp1);
            BigInteger b = BigInteger.valueOf(temp2);
            BigInteger inFront = a.multiply(b);
            BigInteger nowTaste = BigInteger.valueOf(validStops.get(i).taste);
            BigInteger tempRslt = nowTaste.multiply(inFront);
            System.out.println(tempRslt);
            rslt = rslt.add(tempRslt);
            testPos = validStops.get(i).x;
        }

        out.println(rslt);
        br.close();
        out.close();
    }
}