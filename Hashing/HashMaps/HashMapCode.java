package Hashing.HashMaps;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapCode {

    static class HashMap<K, V> { // generic for any datatype Boolean, Integer, String etc.
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; // n
        private int N; // N
        private LinkedList<Node> buckets[]; // N= buckets.length

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4];
            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % N; // 0 to 3 (n)
        }

        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            int di = 0;

            for (int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);
                if (node.key == key) {
                    return di;
                }
                di++;
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node> oldBucket[] = buckets;
            buckets = new LinkedList[N * 2];
            N = N * 2;
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }

            // oldBucket -> newly initialized buckets
            for (int i = 0; i < oldBucket.length; i++) {
                LinkedList<Node> ll = oldBucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }

        }

        public void put(K key, V value) {
            // bucket Index
            int bi = hashFunction(key); // 0 to 3 (n)
            // data Index
            int di = searchInLL(key, bi); // valid; OR -1

            if (di != -1) {
                // if key exist then update value
                Node node = buckets[bi].get(di);
                node.value = value;
            } else {
                // if key not exist then create new node and add it in LinkedList
                buckets[bi].add(new Node(key, value));
                n++;
            }
            // check for Rehashing (check lambda)
            double lambda = (double) n / N;
            if (lambda > 2.0) {
                rehash();
            }

        }

        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di != -1) {
                return true;
            } else {
                return false;
            }
        }

        public V get(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di != -1) {
                // if key exist then return value
                Node node = buckets[bi].get(di);
                return node.value;
            } else {
                return null;
            }
        }

        public V remove(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di != -1) {
                // if key exist then remove value
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            } else {
                return null;
            }
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty() {
            return n == 0;
        }

    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        // Insert - O(1)
        map.put("India", 150);
        map.put("China", 110);
        map.put("USA", 130);
        map.put("Russia", 140);
        map.put("Dubai", 100);

        System.out.println("Size = "+map.n);
        System.out.println(map.get("India"));
        System.out.println(map.get("Japan"));
        
        ArrayList<String> keys = map.keySet();
        
        for (String key : keys) {
            System.out.println(key);
        }
        
        System.out.println(map.get("China"));
        map.remove("China");
        System.out.println(map.get("China"));
    }
}
