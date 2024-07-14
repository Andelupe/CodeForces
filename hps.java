import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class hps {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("hps.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] prefSum = new int[N][3];
        int[] sum = new int[3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            if (temp.equals("S")) {
                sum[0]++;
            } else if (temp.equals("H")) {
                sum[1]++;
            } else {
                sum[2]++;
            }

            prefSum[i][0] = sum[0];
            prefSum[i][1] = sum[1];
            prefSum[i][2] = sum[2];
        }

        int rslt = -1;
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                rslt = Math.max(prefSum[N - 1][0], rslt);
                rslt = Math.max(prefSum[N - 1][1], rslt);
                rslt = Math.max(prefSum[N - 1][2], rslt);
                continue;
            }
            int HtoP = prefSum[i - 1][0] + (prefSum[N - 1][1] - prefSum[i - 1][1]);
            int HtoS = prefSum[i - 1][0] + (prefSum[N - 1][2] - prefSum[i - 1][2]);
            int PtoH = prefSum[i - 1][1] + (prefSum[N - 1][0] - prefSum[i - 1][0]);
            int PtoS = prefSum[i - 1][1] + (prefSum[N - 1][2] - prefSum[i - 1][2]);
            int StoH = prefSum[i - 1][2] + (prefSum[N - 1][0] - prefSum[i - 1][0]);
            int StoP = prefSum[i - 1][2] + (prefSum[N - 1][1] - prefSum[i - 1][1]);
            rslt = Math.max(HtoP, Math.max(HtoS, Math.max(PtoH, Math.max(PtoS, Math.max(StoH, Math.max(StoP, rslt))))));
        }
        out.println(rslt);
        br.close();
        out.close();
    }
    
}
