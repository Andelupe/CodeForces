import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.StringTokenizer;

public class updateQueries {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            String origin = br.readLine().trim();
            st = new StringTokenizer(br.readLine());

            int[] count = new int[N];
            int[] replace = new int[M];
            for (int j = 0; j < M; j++) {
                replace[j] = Integer.parseInt(st.nextToken());
                count[replace[j] - 1]++;
            }

            String replacement = br.readLine().trim();
            Deque<Character> deque = new ArrayDeque<>();
            ArrayList<Character> repList = new ArrayList<>();

            for (int j = 0; j < M; j++) {
                repList.add(replacement.charAt(j));
            }

            StringBuilder rslt = new StringBuilder(origin);
            Arrays.sort(replace);
            Collections.sort(repList);
            for (int j = 0; j < M; j++) {
                deque.add(repList.get(j));
            }

            for (int j = 0; j < M; j++) {
                int index = replace[j] - 1;
                char newChar = ' ';
                for (int k = 0; k < count[index]; k++) {
                    if (k == count[index] - 1) {
                        newChar = deque.removeFirst();
                    } else {
                        deque.removeLast();
                        j++;
                    }
                }
                rslt.replace(index, index + 1, String.valueOf(newChar));
            }

            System.out.println(rslt);
        }
    }
}