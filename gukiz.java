import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class gukiz {

    public static class person implements Comparable<person> {
        int index, score;

        public person(int a, int b) {
            index = a;
            score = b;
        }

        public int compareTo(person p) {
            return -Integer.compare(score, p.score);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        person[] contest = new person[N];
        int[] rslt = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            person a = new person(i, temp);
            contest[i] = a;
        }

        Arrays.sort(contest);
        int currPlace = 1;
        int needAdd = 0;
        int lastUp = -1;
        for (int i = 0; i < N; i++) {
            if (contest[i].score == lastUp) {
                needAdd++;
                rslt[contest[i].index] = currPlace - needAdd;
                currPlace++;
                continue;
            }
            lastUp = contest[i].score;
            rslt[contest[i].index] = currPlace;
            needAdd = 0;
            currPlace++;
        }
        for (int i = 0; i < N; i++) {
            System.out.print(rslt[i] + " ");
        }
    }
}