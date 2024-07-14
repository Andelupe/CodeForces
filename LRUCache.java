import java.io.IOException;
import java.util.HashMap;

class LRUCache {

    HashMap<Integer, Listnode> h;
    int size, cap;
    Listnode head;
    Listnode tail;

    public static class Listnode {
        int val, key;
        Listnode front, back;

        public Listnode(int a, int b, Listnode c, Listnode d) {
            this.val = a;
            this.key = b;
            this.front = c;
            this.back = d;
        }
    }
    public LRUCache(int capacity) {
        h = new HashMap<>();
        cap = capacity;
        size = 0;
        head = null;
        tail = null;
    }
    
    public int get(int key) {
        if (!h.containsKey(key)) {
            return -1;
        }
        if (h.get(key).front == null) {
            return h.get(key).val;
        }
        if (h.get(key) == tail) {
            h.get(key).front.back = null;
            this.tail = h.get(key).front;
        } else {
            h.get(key).front.back = h.get(key).back;
            h.get(key).back.front = h.get(key).front;
        }

        head.front = h.get(key);
        h.get(key).back = head;
        h.get(key).front = null;
        this.head = h.get(key);
        return h.get(key).val;
    }
    
    public void put(int key, int value) {
        if (h.isEmpty()) {
            Listnode temp = new Listnode(value, key, null, null);
            h.put(key, temp);
            this.head = temp;
            this.tail = temp;
            size++;
            return;
        }
        if (h.get(key) != null) {
            h.get(key).val = value;
            get(key);
            return;
        }
        if (size + 1 > cap) {
            if (cap == 1) {
                Listnode temp = new Listnode(value, key, null, null);
                h.remove(head.key);
                this.head = temp;
                this.tail = temp;
                h.put(key, temp);
                return;
            }
            Listnode temp = new Listnode(value, key, null, head);
            h.remove(tail.key);
            h.put(key, temp);
            head.front = temp;
            this.head = temp;
            tail.front.back = null;
            tail = tail.front;
        } else {
            size++;
            Listnode temp = new Listnode(value, key, null, head);
            head.front = temp;
            head = temp;
            h.put(key, temp);
        }
    }

    public static void main(String[] args) throws IOException {
        LRUCache lRUCache = new LRUCache(1);
        lRUCache.put(2, 1); // cache is {1=1}
        lRUCache.get(2);    // return 1
        lRUCache.put(3, 2); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.get(3);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */