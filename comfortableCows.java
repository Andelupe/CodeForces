import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
// import java.util.LinkedList;
// import java.util.Queue;
import java.util.StringTokenizer;

public class comfortableCows {


    public static class coord {
        int x, y;

        public coord(int a, int b) {
            x = a;
            y = b;
        }
    }

    static boolean[][] grid;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        grid = new boolean[10000][10000];
        ArrayList<coord> cows = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int temp1 = Integer.parseInt(st.nextToken());
            int temp2 = Integer.parseInt(st.nextToken());
            grid[temp1][temp2] = true;
            coord temp3 = new coord(temp1, temp2);
            cows.add(temp3);

            if (i <= 2) {
                System.out.println(0);
                continue;
            }

            int rslt = 0;
            // Queue<coord> q = new LinkedList<>();
            for (int j = 0; j < cows.size(); j++) {
                index = new coord(-1, -1);
                // check(cows.get(j), q, grid, cows);
            }

            System.out.println(rslt);
            // remCoord(q);
        }
    }

    static coord index;
//     public static void check(coord cow, Queue<coord> q, boolean[][] matrix, ArrayList<coord> cowList) {
//         int next = 0;
//         boolean left = false;
//         boolean right = false;
//         boolean down = false;

//         if (cow.x != 0 && grid[cow.x - 1][cow.y]) {
//             next++;
//             left = true;
//         }
//         if (cow.y != 0 && grid[cow.x][cow.y - 1]) {
//             next++;
//             down = true;
//         }
//         if (grid[cow.x][cow.y + 1]) {
//             next++;
//         }
//         if (grid[cow.x + 1][cow.y]) {
//             next++;
//             right = true;
//         }

//         if (next == 3) {
//             if (!left) {
//                 coord temp = new coord(cow.x - 1, cow.y);
//                 index = temp;
//             } else if (!down) {
//                 coord temp = new coord(cow.x, cow.y - 1);
//                 index = temp;
//             } else if (!right) {
//                 coord temp = new coord(cow.x + 1, cow.y);
//                 index = temp;
//             } else {
//                 coord temp = new coord(cow.x, cow.y + 1);
//                 index = temp;
//             }
            
//             q.add(index);
//             grid[index.x][index.y] = true;
//             if (index.x != 0) {
//                 coord nCoord = new coord(index.x - 1, index.y);
//                 if (cowList.contains(nCoord)) {
//                     check(nCoord, q, matrix, cowList);
//                 }
//             }
//             if (index.y != 0) {
//                 coord nCoord = new coord(index.x, index.y - 1);
//                 if (cowList.contains(nCoord))
//             }
//             coord nCoord1 = new coord(index.x + 1, index.y);
//             coord nCoord2 = new coord(index.x, index.y + 1);
//         }
//     }

//     public static void remCoord(Queue<coord> q) {
//         while (!q.isEmpty()) {
//             coord v = q.poll();
//             grid[v.x][v.y] = false;
//         }
//     }
// }
}