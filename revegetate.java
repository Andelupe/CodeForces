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

public class revegetate {

    public static class Edge {
        int to;
        boolean diff;

        public Edge(int to, boolean diff) {
            this.to = to;
            this.diff = diff;
        }
    }

    static ArrayList<Edge>[] adj;
    static boolean[] visited;
    static int[] label;
    static boolean isValid;
    static int components;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("revegetate.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("revegetate.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N];
        visited = new boolean[N];
        label = new int[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            boolean d = a.equals("D");
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            adj[b].add(new Edge(c, d));
            adj[c].add(new Edge(b, d));
        }

        Arrays.fill(label, -1);
        isValid = true;
        components = 0;

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                components++;
                if (!bipartite(i)) {
                    isValid = false;
                    break;
                }
            }
        }

        int result = isValid ? (1 << components) : 0;
        out.println(Integer.toBinaryString(result));
        out.close();
        br.close();
    }

    public static boolean bipartite(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        label[start] = 1;
        visited[start] = true;

        while (!q.isEmpty()) {
            int v = q.poll();
            int currLabel = label[v];

            for (Edge e : adj[v]) {
                if (visited[e.to]) {
                    int expectedLabel = e.diff ? 3 - currLabel : currLabel;
                    if (label[e.to] != expectedLabel) {
                        return false;
                    }
                } else {
                    visited[e.to] = true;
                    label[e.to] = e.diff ? 3 - currLabel : currLabel;
                    q.add(e.to);
                }
            }
        }
        return true;
    }
}