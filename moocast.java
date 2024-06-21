import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class moocast {

    public static class Cow {
        double x, y, r;

        public Cow(double a, double b, double c) {
            x = a;
            y = b;
            r = c;
        }

        public double dist(Cow c) {
            double a = Math.pow(Math.abs(x - c.x), 2);
            double b = Math.pow(Math.abs(y - c.y), 2);
            return Math.sqrt(a + b);
        }
    }

    static ArrayList<Integer>[] adj;
    static int N, rslt;
    static boolean[] visited = new boolean[N];
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("moocast.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N];
        Cow[] cows = new Cow[N];

        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<Integer>();
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            Cow temp = new Cow(a, b, c);
            cows[i] = temp;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (cows[i].dist(cows[j]) <= cows[i].r && i != j) {
                    adj[i].add(j);
                }
            }
        }

        int maxRslt = -1;
        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            Arrays.fill(visited, false);
            visited[i] = true;
            rslt = 1;
            bfs(i);
            maxRslt = Math.max(rslt, maxRslt);
        }

        out.println(maxRslt);
        br.close();
        out.close();

    }

    public static void bfs(int k) {
        Queue<Integer> q = new LinkedList<>();
        q.add(k);
        while (!q.isEmpty()) {
            int v = q.poll();
            for (int e : adj[v]) {
                if (visited[e] == false) {
                    rslt++;
                    q.add(e);
                    visited[e] = true;
                }
            }
        }
    }
}