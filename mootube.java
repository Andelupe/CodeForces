import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class mootube {

    public static class Edge {
        int to, weight;

        public Edge(int a, int b) {
            to = a;
            weight = b;
        }
    }


    static int N, rslt, K;
    static ArrayList<Edge>[] adj;
    static boolean[] visited = new boolean[N];

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("mootube.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mootube.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        int Q = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<Edge>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());
            Edge temp1 = new Edge(b, w);
            Edge temp2 = new Edge(a, w);
            adj[a].add(temp1);
            adj[b].add(temp2);
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken()) - 1;
            rslt = 0;
            Arrays.fill(visited, false);
            visited[V] = true;
            dfs(V, Integer.MAX_VALUE, Integer.MAX_VALUE);
            out.println(rslt);
        }
        out.close();
        br.close();
    }

    public static void dfs(int node, int minWeight, int currWeight) {
        minWeight = Math.min(minWeight, currWeight);
        if (minWeight >= K && minWeight != Integer.MAX_VALUE) rslt++;
        for (Edge next : adj[node]) {
            if (!visited[next.to]) {
                visited[next.to] = true;
                dfs(next.to, minWeight, next.weight);
            }
        }

        return;
    }
}