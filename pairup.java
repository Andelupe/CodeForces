import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class pairup {

    public static class cow {
        int X, Y;

        public cow(int a, int b) {
            X = a;
            Y = b;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("pairup.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pairup.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        ArrayList<cow> cows = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            cow temp = new cow(X, Y);
            cows.add(temp);
        }
        Collections.sort(cows, (a, b) -> a.Y - b.Y);
        int left = 0;
        int right = cows.size() - 1;
        int rslt = 0;
        while (right > left) {
            int dec = Math.min(cows.get(left).X, cows.get(right).X);
            rslt = Math.max(rslt, cows.get(right).Y + cows.get(left).Y);
            if (cows.get(left).X == cows.get(right).X) {
                right--;
                left++;
                continue;
            }
            if (cows.get(left).X < cows.get(right).X) {
                cows.get(right).X -= dec;
                left++;
                continue;
            } else {
                cows.get(left).X -= dec;
                right--;
                continue;
            }
        }
        out.println(rslt);
        out.close();
        br.close();
    }
}