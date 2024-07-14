import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class wormSort {

    static int[] parent;

    public static void initialize(int N) {
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
    }

    public static int find(int x) {
        if (parent[x] == x) {
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

    public static class hole {
        int a, b, weight;

        public hole(int z, int x, int c) {
            a = z;
            b = x;
            weight = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("wormsort.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormsort.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        parent = new int[N];
        boolean[] inOrder = new boolean[N];
        int[] index = new int[N];
        ArrayList<hole> worms = new ArrayList<>();
        initialize(N);

        boolean asc = true;
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken()) - 1;
            if (temp == i) {
                inOrder[i] = true;
            } else {
                asc = false;
            }
            index[i] = temp;
        }

        if (asc) {
            out.println("-1");
        }

        for (int i = 0; i < M; i++) {
            if (asc) break;
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            hole hi = new hole(a, b, c);
            worms.add(hi);
        }

        Collections.sort(worms, (a, b) -> b.weight - a.weight);
        for (int i = 0; i < M; i++) {
            if (asc) break;
            if (find(worms.get(i).a) != find(worms.get(i).b)) {
                union(worms.get(i).a, worms.get(i).b);
            }

            if (check(inOrder, N)) {
                out.println(worms.get(i).weight);
                break;
            }
        }

        out.close();
        br.close();
    }

    public static boolean check(boolean[] inOrder, int N) {
        boolean good = true;
        boolean first = true;
        int cIndex = -1;
        for (int i = 0; i < N; i++) {
            if (inOrder[i]) {
                continue;
            }

            if (first) {
                cIndex = find(i);
                first = false;
                continue;
            }

            if (cIndex != find(i)) {
                good = false;
                break;
            }
        }

        return good;
    }
}