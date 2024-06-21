import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class polyCarps {

    public static class Problem {
        int index; int profit;
        public Problem(int a, int b) {
            index = a;
            profit = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<Problem> poly = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int temp1 = i;
            int temp2 = Integer.parseInt(st.nextToken());
            Problem temp3 = new Problem(temp1, temp2);
            poly.add(temp3);
        }

        Collections.sort(poly, (a, b) -> b.profit - a.profit);
        ArrayList<Problem> counted = new ArrayList<>();
        int totalRslt = 0;
        for (int i = 0; i < K; i++) {
            counted.add(poly.get(i));
            totalRslt += poly.get(i).profit;
        }

        Collections.sort(counted, (a, b) -> a.index - b.index);
        int prevIndex = -1;
        System.out.println(totalRslt);
        for (int i = 0; i < K; i++) {
            if (i == K - 1) {
                System.out.print(N - 1 - prevIndex);
                continue;
            }
            System.out.print(counted.get(i).index - prevIndex + " ");
            prevIndex = counted.get(i).index;
        }
        br.close();
    }
}