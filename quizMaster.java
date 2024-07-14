import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class quizMaster {

    public static class student {
        int val;
        ArrayList<Integer> factors;

        public student(int a, int M) {
            factors = new ArrayList<>();
            for (int i = 1; i <= M; i++) {
                if (i > a) {
                    break;
                }
                if (a % i == 0) {
                    factors.add(i);
                }
            }
            val = a;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        
        for (int j = 0; j < T; j++) {

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            student[] students = new student[N];
            int[] quizzes = new int[M + 1];
            HashSet<Integer> check = new HashSet<>();

            for (int i = 0; i < N; i++) {
                student temp = new student(Integer.parseInt(st.nextToken()), M);
                students[i] = temp;
            }
            Arrays.sort(students, (a, b) -> a.val - b.val);

            int left = 0, right = 0, rslt = Integer.MAX_VALUE;
            boolean stay = false;
            while (left < N && right < N) {

                while (right < N) {
                    if (stay) {
                        if (check.size() == M) {
                            rslt = Math.min(rslt, students[right].val - students[left].val);
                        }
                        break;
                    }
                    for (int i = 0; i < students[right].factors.size(); i++) {
                        quizzes[students[right].factors.get(i)]++;
                        check.add(students[right].factors.get(i));
                    }
                    if (check.size() == M) {
                        rslt = Math.min(rslt, students[right].val - students[left].val);
                        break;
                    }
                    right++;
                }
                if (right == N) {
                    right = N - 1;
                    stay = true;
                }
                for (int i = 0; i < students[left].factors.size(); i++) {
                    quizzes[students[left].factors.get(i)]--;
                    if (quizzes[students[left].factors.get(i)] == 0) {
                        check.remove(students[left].factors.get(i));
                    }
                }
                left++;
                if (left > right) {
                    right++;
                }
            }
            if (rslt == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(rslt);
            }
        }
    }
}