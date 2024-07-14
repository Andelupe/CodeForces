import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class vasya {

    public static class listNode {
        int val;
        listNode front, back;

        public listNode(int a, listNode b, listNode c) {
            this.val = a;
            this.front = b;
            this.back = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        HashMap<Integer, listNode> h = new HashMap<>();
        listNode head = new listNode(Integer.parseInt(st.nextToken()), null, null);
        listNode curr = head;
        for (int i = 1; i < N; i++) {
            listNode temp = new listNode(Integer.parseInt(st.nextToken()), curr, null);
            curr.back = temp;
            h.put(curr.val, curr);
            curr = temp;
        }
        h.put(curr.val, curr);
        curr = head;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int grab = Integer.parseInt(st.nextToken());
            if (!h.containsKey(grab)) {
                System.out.print(0 + " ");
                continue;
            }
            int rslt = 0;
            while (curr != null) {
                if (curr.val == grab) {
                    rslt++;
                    h.remove(curr.val);
                    curr = curr.back;
                    System.out.print(rslt + " ");
                    break;
                }
                h.remove(curr.val);
                curr = curr.back;
                rslt++;
            }
        }
    }
}