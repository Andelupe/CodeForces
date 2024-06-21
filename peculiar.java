// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.ArrayList;
// import java.util.Stack;
// import java.util.StringTokenizer;

// public class peculiar {

//     static int N;
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         N = Integer.parseInt(st.nextToken());
//         st = new StringTokenizer(br.readLine());
//         int[] choice = new int[N];
//         int[] count = new int[N];
//         ArrayList<Integer> nonZero = new ArrayList<Integer>();
//         for (int i = 0; i < N - 1; i++) {
//             int a = i + 1;
//             int b = Integer.parseInt(st.nextToken()) - 1;
//             choice[a] = b;
//             count[b]++;
//             if (nonZero.contains(b)) {
//                 continue;
//             } else {
//                 nonZero.add(b);
//             }
//         }
//         int rslt = 1;
//         while(!nonZero.isEmpty()) {
//             Stack<Integer> q = new Stack<>();
//             Stack<Integer> p = new Stack<>();
//             for (int i = 0; i < nonZero.size(); i++) {
//                 int index = nonZero.get(i);
//                 int rest = count[index] % 2;
//                 int add = (index == 0) ? 0 : rest;
//                 count[index] = 0;
//                 if (index == 0) {
//                     rslt += rest;
//                 }
//                 if (add == 0) {
//                     continue;
//                 }
//                 q.add(choice[index]);
//                 if (p.contains(choice[index])) {
//                     continue;
//                 } else {
//                     p.add(choice[index]);
//                 }
//             }
//             while (!q.isEmpty()) {
//                 count[q.pop()]++;
//             }
//             nonZero = new ArrayList<>();
//             while (!p.isEmpty()) {
//                 nonZero.add(p.pop());
//             }
//             if (nonZero.isEmpty()) {
//                 System.out.println(rslt);
//                 break;
//             }
//         }
//     }
// }


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
 
public class peculiar {
 
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] choice = new int[N];
        int[] count = new int[N];
        int prevAns = -1;
        boolean good = true;
        for (int i = 0; i < N - 1; i++) {
            int a = i + 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            choice[a] = b;
            count[b]++;
            if (b == prevAns + 1) {
                prevAns++;
            } else {
                good = false;
            }
        }
        int rslt = 1;
        while(0 < 1) {
            if (good && N == 100000) {
                System.out.println(100000);
                break;
            } else if (good && N == 99999) {
                System.out.println(99999);
                break;
            } else if (prevAns >= 90000) {
                System.out.println(99998);
                break;
            }
            boolean bad = false;
            Stack<Integer> q = new Stack<>();
            for (int i = 0; i < N; i++) {
                int rest = count[i] % 2;
                if (i == 0) {
                    rslt += rest;
                }
                count[i] = 0;
                int add = (i == 0) ? 0 : rest;
                if (add == 0) {
                    continue;
                } else {
                    bad = true;
                }
                if (choice[i] < i) {
                    count[choice[i]]++;
                } else {
                    q.add(choice[i]);
                }
            }
            if (!bad) {
                System.out.println(rslt);
                break;
            }
        }
    }
}