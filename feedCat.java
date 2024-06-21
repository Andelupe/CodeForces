import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class feedCat {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        double hunger = Integer.parseInt(st.nextToken());
        double moreHungry = Integer.parseInt(st.nextToken());
        double cost = Integer.parseInt(st.nextToken());
        double feed = Integer.parseInt(st.nextToken());

        double rslt = -1;

        double minDiscount = Integer.MAX_VALUE;
        if (M == 0 && H < 20) {
            minDiscount = (20 - H) * 60;
        } else if (H < 20) {
            minDiscount = (19 - H) * 60 + (60 - M);
        }

        if (minDiscount == Integer.MAX_VALUE) {
            rslt = Math.ceil(hunger / feed) * (cost * 0.8);
        } else {
            double newHunger = hunger + (moreHungry * minDiscount);
            double wait = Math.ceil(newHunger / feed) * (cost * 0.8);
            double now = Math.ceil(hunger / feed) * (cost);
            rslt = Math.min(wait, now);
        }

        System.out.println(rslt);
        br.close();
    }
}