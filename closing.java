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

public class closing {

    static int N, M, rslt;
    static ArrayList<Integer>[] adj;
    static boolean[] visited = new boolean[N];
    static boolean[] closed = new boolean[N];

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("closing.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("closing.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N];
        ArrayList<Integer> notClosed = new ArrayList<>();
        closed = new boolean[N];

        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<Integer>();
            notClosed.add(i);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            adj[a].add(b);
            adj[b].add(a);
        }

        int hit = 0;
        for (int i = -1; i < N; i++) {
            rslt = 1;
            visited = new boolean[N];
            Arrays.fill(visited, false);
            if (i == -1) {
                visited[0] = true;
                bfs(0);
            } else {
                st = new StringTokenizer(br.readLine());
                int temp = Integer.parseInt(st.nextToken()) - 1;
                closed[temp] = true;
                notClosed.remove(Integer.valueOf(temp));
                if (notClosed.isEmpty()) break;
                visited[notClosed.get(0)] = true;
                bfs(notClosed.get(0));
                hit++;        
            }

            if (rslt == N - hit) {
                out.println("YES");
            } else {
                out.println("NO");
            }

            
        }

        out.close();
        br.close();
    }

    public static void bfs(int k) {
        Queue<Integer> q = new LinkedList<>();
        q.add(k);
        while (!q.isEmpty()) {
            int v = q.poll();
            for (int e : adj[v]) {
                if (!visited[e] && !closed[e]) {
                    q.add(e);
                    visited[e] = true;
                    rslt++;
                }
            }
        }    
    }
}