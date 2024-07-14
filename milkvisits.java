import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class milkvisits {

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
        BufferedReader br = new BufferedReader(new FileReader("milkvisits.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N];
        char[] type = br.readLine().trim().toCharArray();
        initialize(N);
        boolean[] H = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (type[i] == 'H') {
                H[i] = true;
            }
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int temp1 = Integer.parseInt(st.nextToken()) - 1;
            int temp2 = Integer.parseInt(st.nextToken()) - 1;
            if (H[temp1] && H[temp2]) {
                union(temp1, temp2);
            }
            if (!H[temp1] && !H[temp2]) {
                union(temp1, temp2);
            }
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            String c = st.nextToken();
            if (parent[a] == parent[b]) {
                if (c.equals("H") && H[a]) {
                    out.print("1");
                } else if (c.equals("G") && !H[a]) {
                    out.print("1");
                } else {
                    out.print("0");
                }
            } else {
                out.print("1");
            }

        }

        out.close();
        br.close();
    }
}