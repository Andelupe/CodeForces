import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class moop {

    static int[] parent;

    public static void initialize(int N) {
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
    }

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }

    public static void union(int a, int b) {
        int c = find(a);
        int d = find(b);
        if (c != d) {
            parent[d] = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("moop.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moop.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        parent = new int[N];
        int[][] vals = new int[N][2];
        initialize(N);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            vals[i][0] = Integer.parseInt(st.nextToken());
            vals[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(vals, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            } else {
                return Integer.compare(a[0], b[0]);
            }
        });
        
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if ((vals[j][0] >= vals[i][0] && vals[j][1] >= vals[i][1]) || 
                    (vals[j][0] <= vals[i][0] && vals[j][1] <= vals[i][1])) {
                    union(i, j);
                }
            }
        }

        int rslt = N;
        for (int i = 0; i < N; i++) {
            if (parent[i] != i) rslt--;
        }

        out.println(rslt);
        out.close();
        br.close();
    }
}