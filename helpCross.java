import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class helpCross {
    
    public static class cow implements Comparable<cow> {
        int start; int end;
        public cow(int a, int b) {
            start = a;
            end = b;
        }

        public int compareTo(cow c) {
            if (start != c.start) {
                return Integer.compare(start, c.start);
            } else {
                return Integer.compare(end, c.end);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("helpcross.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("helpcross.out")));
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> chickens = new PriorityQueue<>();
        ArrayList<cow> cows = new ArrayList<>();

        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());
            chickens.add(Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int temp1 = Integer.parseInt(st.nextToken());
            int temp2 = Integer.parseInt(st.nextToken());
            cow temp3 = new cow(temp1, temp2);
            cows.add(temp3);
        }
        Collections.sort(cows);
        PriorityQueue<Integer> availableCows = new PriorityQueue<>();
        int cowIndex = 0;
        int pairs = 0;
        while (!chickens.isEmpty()) {
            int chickenTime = chickens.poll();
            while (cowIndex < cows.size() && cows.get(cowIndex).start <= chickenTime) {
                availableCows.add(cows.get(cowIndex).end);
                cowIndex++;
            }
            while (!availableCows.isEmpty() && availableCows.peek() < chickenTime) {
                availableCows.poll();
            }
            if (!availableCows.isEmpty()) {
                availableCows.poll();
                pairs++;
            }
        }

        out.println(pairs);
        out.close();
        br.close();
    }
}