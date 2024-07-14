import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class matrix {

    public static class Pair {
        int x, y, val;

        public Pair(int a, int b, int c) {
            x = a;
            y = b;
            val = c;
        }

        public int getVal() {
            return val;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] matrix = new int[N][M];
            PriorityQueue<Pair> maxHeap = new PriorityQueue<>(
                    Comparator.comparingInt(Pair::getVal).reversed()
                      .thenComparingInt(Pair::getX)
                      .thenComparingInt(Pair::getY)
            );
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    int temp = Integer.parseInt(st.nextToken());
                    matrix[j][k] = temp;
                    Pair temp2 = new Pair(j, k, temp);
                    maxHeap.add(temp2);
                }
            }

            while(!maxHeap.isEmpty()) {
                Pair v = maxHeap.poll();
                int n = neighbor(v.x, v.y, N, M, matrix);
                if (v.val <= n) {
                    continue;
                } else {
                    matrix[v.x][v.y] = n;
                }
            }

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    System.out.print(matrix[j][k] + " ");
                }
                System.out.println();
            }
        }
    }

    public static int neighbor(int x, int y, int row, int col, int[][] arr) {
        int maxNeighbor = -1;
        if (x != 0) {
            maxNeighbor = Math.max(arr[x - 1][y], maxNeighbor);
        }
        if (y != 0) {
            maxNeighbor = Math.max(arr[x][y - 1], maxNeighbor);
        }
        if (x != row - 1) {
            maxNeighbor = Math.max(arr[x + 1][y], maxNeighbor);
        }
        if (y != col - 1) {
            maxNeighbor = Math.max(arr[x][y + 1], maxNeighbor);
        }

        return maxNeighbor;
    }
}