import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class mathProblem {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine().trim());
            String test = br.readLine().trim();
            if (N <= 2) {
                System.out.println(Integer.parseInt(test));
                continue;
            }

            int min = Integer.MAX_VALUE;
            int index = -1;
            boolean allOnes = true;
            boolean containsZero = false;
            for (int j = 0; j < N - 1; j++) {
                if (Integer.parseInt(test.substring(j, j+1)) == 0) {
                    if (N == 3 && j == 1) {

                    } else {
                        containsZero = true;
                        break;
                    }
                }
                int temp = Integer.parseInt(test.substring(j, j + 2));
                if (temp != 11) {
                    allOnes = false;
                }
                if ((temp / 10 == 1 || temp % 10 == 1) && N > 3) {
                    continue;
                }
                if (temp < min) {
                    index = j;
                }

                min = Math.min(temp, min);
            }

            int rslt = 0;
            for (int j = 0; j < N; j++) {
                if (containsZero) {
                    break;
                }
                if (allOnes) {
                    rslt = min;
                    break;
                }
                int temp = Integer.parseInt(test.substring(j, j + 1));
                if (j == index) {
                    if (min == 1) {
                        if (N == 3) {
                            rslt = 1;
                        }
                        j++;
                        continue;
                    }
                    rslt += Integer.parseInt(test.substring(j, j + 2));
                    j++;
                    continue;
                }
                if (temp == 1) {
                    continue;
                }
                rslt += temp;
            }
            System.out.println(rslt);
        }
    }
}