// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.FileReader;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.io.PrintWriter;
// import java.util.ArrayList;
// import java.util.StringTokenizer;

// public class closingGold {
    
//     static int[] parent;
//     static boolean[] open;
//     static ArrayList<Integer>[] adj;
    
//     public static void initialize(int N) {
//         for (int i = 0; i < N; i++) {
//             parent[i] = i;
//             adj[i] = new ArrayList<>();
//         }
//     }

//     public static int find(int x) {
//         if (parent[x] == x) {
//             return x;
//         } else {
//             return parent[x] = find(parent[x]);
//         }
//     }

//     public static void union(int a, int b) {
//         int c = find(a);
//         int d = find(b);
//         if (c != d) {
//             parent[d] = c;
//         }
//     }

//     public static boolean check(int N) {
//         int c = find(getOpen());
            
//         for (int j = 0; j < N; j++) {
//             if (!open[j]) continue;
//             if (find(j) != c) {
//                 return false;
//             }
//         }
//         return true;
//     }

//     public static int getOpen() {
//         int count = 0;
//         for (boolean b : open) {
//             if (b) return count;
//             count++;
//         }
//         return -1;
//     }

//     public static void openFarm(int farm) {
//         open[farm] = true;
//         for (int neighbor : adj[farm]) {
//             if (open[neighbor]) {
//                 union(farm, neighbor);
//             }
//         }
//     }

//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new FileReader("closing.in"));
//         PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("closing.out")));
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         int N = Integer.parseInt(st.nextToken());
//         int M = Integer.parseInt(st.nextToken());
//         open = new boolean[N];
//         parent = new int[N];
//         adj = new ArrayList[N];
//         initialize(N);
//         for (int i = 0; i < M; i++) {
//             st = new StringTokenizer(br.readLine());
//             int a = Integer.parseInt(st.nextToken()) - 1;
//             int b = Integer.parseInt(st.nextToken()) - 1;
//             adj[a].add(b);
//             adj[b].add(a);
//             union(a, b);
//         }

//         int[] order = new int[N];
//         for (int i = 0; i < N; i++) {
//             st = new StringTokenizer(br.readLine());
//             order[i] = Integer.parseInt(st.nextToken()) - 1;
//         }

//         boolean[] rslt = new boolean[N];
//         for (int i = N - 1; i >= 0; i--) {
//             openFarm(order[i]);
//             if (i == N - 1) continue;
//             rslt[i + 1] = check(N);
//         }

//         for (boolean b : rslt) {
//             System.out.println(b);
//         }

//         out.close();
//         br.close();
//     }
// }




import java.io.*;
import java.util.*;

public class closingGold {
    private static final int MAXN = 200000;
    private static int[] order = new int[MAXN];
    private static int[] place = new int[MAXN];
    private static int[] u = new int[MAXN];
    private static int[] v = new int[MAXN];
    private static int[] par = new int[MAXN];
    private static boolean[] res = new boolean[MAXN];
    private static int N, M;
    private static List<List<Integer>> adj = new ArrayList<>();

    public static void unionInit(int[] d, int s) {
        for (int i = 0; i < s; i++) d[i] = i;
    }

    public static int unionQuery(int[] d, int n) {
        int res = n;
        while (d[res] != res) res = d[res];
        int m;
        while (d[n] != n) {
            m = d[n];
            d[n] = res;
            n = m;
        }
        return res;
    }

    public static int unionMerge(int[] d, int x, int y) {
        x = unionQuery(d, x);
        y = unionQuery(d, y);
        if (x == y) return -1;
        d[x] = y;
        return 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("closing.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("closing.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            order[i] = Integer.parseInt(st.nextToken());
            place[order[i]] = i;
        }

        adj = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            if (place[u[i]] > place[v[i]]) {
                adj.get(v[i]).add(u[i]);
            } else {
                adj.get(u[i]).add(v[i]);
            }
        }

        unionInit(par, N + 1);
        int comps = 0;

        for (int i = N - 1; i >= 0; i--) {
            int u = order[i];
            comps++;

            for (int j = 0; j < adj.get(u).size(); j++) {
                int v = adj.get(u).get(j);
                if (unionQuery(par, u) != unionQuery(par, v)) {
                    unionMerge(par, u, v);
                    comps--;
                }
            }

            res[i] = (comps <= 1);
        }

        for (int i = 0; i < N; i++) {
            if (res[i]) {
                out.println("YES");
            } else {
                out.println("NO");
            }
        }

        out.close();
        br.close();
    }
}