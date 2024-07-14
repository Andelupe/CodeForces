import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class booksExchange {


    static ArrayList<Integer>[] adj;
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int Q = Integer.parseInt(st.nextToken());
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            adj = new ArrayList[N];
            for (int j = 0; j < N; j++) {
                adj[j] = new ArrayList<Integer>();
            }
            for (int j = 0; j < N; j++) {
                int a = Integer.parseInt(st.nextToken()) - 1;
                adj[j].add(a);
            }

            solved = new boolean[N];
            visited = new boolean[N];
            start = new int[N];
            rslt = new int[N];
            Arrays.fill(start, -1);
            for (int j = 0; j < N; j++) {
                if (solved[j]) continue;
                dfs(j, 0);
            }
            for (int j = 0; j < N; j++) {
                System.out.print(rslt[j] + " ");
            }
            System.out.println();
        }
    }

    static boolean[] solved;
    static boolean[] visited;
    static int[] start;
    static int[] rslt;

    public static void dfs(int x, int curr) {
        if (solved[x]) {
            return;
        }
        if (start[x] == -1) {
            start[x] = curr;
        }
        if (visited[x] && !solved[x]) {
            solved[x] = true;
            rslt[x] = curr - start[x];
        }
        visited[x] = true;
        curr++;
        int temp = adj[x].get(0);
        dfs(temp, curr);
    }
}
