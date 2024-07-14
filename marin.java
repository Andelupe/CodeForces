import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class marin {

    public static void generate(int[] arr, int k) {
        if (k == 1) {
            check(arr);
        } else {
            generate(arr, k - 1);
            for (int i = 0; i < k - 1; i++) {
                if (k % 2 == 0) {
                    swap(arr, i, k - 1);
                } else {
                    swap(arr, 0, k - 1);
                }

                generate(arr, k - 1);
            }
        }
    }

    public static void check(int[] arr) {
        if (arr.length == 1) {
            rslt = 0;
            return;
        }
        int curr = findGCD(arr[0] * 1, arr[1] * 2);
        for (int i = 2; i < arr.length; i++) {
            curr = findGCD(curr, arr[i] * (i + 1));
        }
        if (curr > 1) {
            rslt++;
            rslt %= 998244353;
        }
    }

    public static int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static int rslt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine().trim());
            rslt = 0;
            int[] nums = new int[N];
            for (int j = 0; j < N; j++) {
                nums[j] = j + 1;
            }
            generate(nums, N);
            System.out.println(rslt);
        }
    }
}