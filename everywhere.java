import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class everywhere {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        String house = br.readLine().trim();
        HashSet<String> poke = new HashSet<>();
        for (int i = 0; i < N; i++) {
            poke.add(house.substring(i, i + 1));
        }
        int left = 0, right = 0, rslt = Integer.MAX_VALUE;
        int currHouse = 0;
        HashSet<String> curr = new HashSet<>();
        ArrayList<String> check = new ArrayList<>();
        while (left < N && right < N) {
            while (right < N) {
                if (curr.size() == poke.size()) {
                    break;
                }
                
                check.add(house.substring(right, right + 1));
                curr.add(house.substring(right, right + 1));
                right++;
                currHouse++;
            }
            if (right == N) {
                right--;
            }
            if (curr.size() == poke.size()) {
                rslt = Math.min(rslt, currHouse);
            }
            check.remove(house.substring(left, left + 1));
            if (!check.contains(house.substring(left, left + 1))) {
                curr.remove(house.substring(left, left + 1));
            }
            left++;
            currHouse--;
        }
        System.out.println(rslt);
    }
}