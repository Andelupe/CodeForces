import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class findColor {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int sector = findSector(x, y);
        double radius = Math.ceil(dist(x, y));

        if (dist(x, y) == (int) dist(x, y)) {
            System.out.println("black");
        } else if (sector == 1 || sector == 3) {
            if (radius % 2 == 0) {
                System.out.println("white");
            } else {
                System.out.println("black");
            }
        } else {
            if (radius % 2 == 0) {
                System.out.println("black");
            } else {
                System.out.println("white");
            }
        }


    }

    public static int findSector(int a, int b) {
        if (a >= 0 && b >= 0) {
            return 1;
        }
        if (a <= 0 && b >= 0) {
            return 2;
        }
        if (a <= 0 && b <= 0) {
            return 3;
        }
        if (a >= 0 && b <= 0) {
            return 4;
        }
        return -1;
    }

    public static double dist(double a, double b) {
        double temp1 = Math.pow(Math.abs(a - 0), 2);
        double temp2 = Math.pow(Math.abs(b - 0), 2);
        return Math.sqrt(temp1 + temp2);
    }
}