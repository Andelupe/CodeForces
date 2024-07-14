import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class convention {
    static int N, M, C;
    static int[] t;

    public static boolean pos(int wait) {
        int wagons = 1;
        int firstArrival = t[0];
        int firstIndex = 0;
        for (int i = 1; i < N; i++) {
            if (t[i] - firstArrival > wait || i + 1 - firstIndex > C) {
                wagons++;
                firstArrival = t[i];
                firstIndex = i;
            }
        }
        return wagons <= M;
    }

    public static int binSearch(int low, int high) {
        if (low == high) return low;
        if (low + 1 == high) {
            if (pos(low)) return low;
            return high;
        }
        int mid = (low + high) / 2;
        if (pos(mid)) return binSearch(low, mid);
        else return binSearch(mid + 1, high);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("convention.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("convention.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        t = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            t[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        Arrays.sort(t);
        out.println(binSearch(0, 1000000000));
        out.close();
        br.close();
    }
}