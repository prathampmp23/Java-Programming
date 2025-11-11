package LinkedList;

import java.util.*;

// Node class represents an entry with key, value, and frequency
class Node {
    int key, value, freq;
    Node next, prev;

    public Node(int key, int value) {
        this.key = key; // key of the cache item
        this.value = value; // value of the cache item
        this.freq = 1; // initial frequency = 1
    }
}

// Doubly Linked List for nodes with the same frequency
class DLL {
    Node head, tail;
    int size;

    DLL() {
        head = new Node(0, 0); // dummy head node
        tail = new Node(0, 0); // dummy tail node
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    void addFirst(Node node) {
        // Insert node right after head (most recently used position)
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
        size++;
    }

    void remove(Node node) {
        // Remove a node from the list
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    Node removeLast() {
        // Remove the least recently used node (before tail)
        if (size == 0)
            return null;
        Node last = tail.prev;
        remove(last);
        return last;
    }
}

class LFUCache {
    int capacity, minFreq;
    Map<Integer, Node> cache; // key → node mapping
    Map<Integer, DLL> frequency; // freq → DLL mapping

    public LFUCache(int capacity) {
        this.capacity = capacity; // total cache capacity
        this.minFreq = 0; // track smallest frequency
        this.cache = new HashMap<>();
        this.frequency = new HashMap<>();
    }

    public int get(int key) {
        // Retrieve value and increase its frequency
        if (!cache.containsKey(key))
            return -1;
        Node node = cache.get(key);
        updateFreq(node);
        return node.value;
    }

    public void put(int key, int value) {
        // Insert or update a key-value pair
        if (capacity == 0)
            return;

        // Case 1: Key already exists → update value + frequency
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            updateFreq(node);
            return;
        }

        // Case 2: New key, cache is full → evict least frequently used
        if (cache.size() == capacity) {
            DLL list = frequency.get(minFreq);
            Node removed = list.removeLast(); // LRU node from least freq
            cache.remove(removed.key);
        }

        // Create new node with frequency = 1
        Node node = new Node(key, value);
        cache.put(key, node);

        DLL list = frequency.get(1);
        if (list == null) {
            list = new DLL();
            frequency.put(1, list);
        }
        list.addFirst(node);

        minFreq = 1; // reset minimum frequency to 1
    }

    private void updateFreq(Node node) {
        // Increase the frequency of a node and move it to the new list
        int oldFreq = node.freq;
        DLL oldList = frequency.get(oldFreq);
        oldList.remove(node);

        // If this was the only node in minFreq list, increment minFreq
        if (oldFreq == minFreq && oldList.size == 0) {
            minFreq++;
        }

        node.freq++; // increment node frequency

        // Add to new frequency list (create if missing)
        DLL newList = frequency.get(node.freq);
        if (newList == null) {
            newList = new DLL();
            frequency.put(node.freq, newList);
        }
        newList.addFirst(node);
    }

    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(2); // Cache capacity = 2

        lfu.put(1, 10); // Cache = {1=10}
        lfu.put(2, 20); // Cache = {1=10, 2=20}
        System.out.println(lfu.get(1)); // returns 10 → freq(1)=2 now

        lfu.put(3, 30); // Evicts key 2 (LFU). Cache = {1=10, 3=30}
        System.out.println(lfu.get(2)); // returns -1 (2 was evicted)
        System.out.println(lfu.get(3)); // returns 30 → freq(3)=2 now
        System.out.println(lfu.get(1)); // returns 10 → freq(1)=3 now

        lfu.put(4, 40); // Evicts key 3 (LFU). Cache = {1=10, 4=40}
        System.out.println(lfu.get(3)); // returns -1 (3 was evicted)
        System.out.println(lfu.get(4)); // returns 40
        System.out.println(lfu.get(1)); // returns 10
    }
}
