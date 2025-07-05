package Heaps;

import java.util.ArrayList;

public class MinHeap {

    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        // O(logn)
        public void add(int data) {
            // add at last index
            arr.add(data);

            // x -> child
            int x = arr.size() - 1;
            int parent = (x - 1) / 2;

            // O(logn)
            while (arr.get(x) < arr.get(parent)) {
                // swap
                int temp = arr.get(x);
                arr.set(x, arr.get(parent));
                arr.set(parent, temp);

                x = parent;
                parent = (x - 1) / 2;
            }
        }

        public int peek() {
            return arr.get(0);
        }

        // O(logn)
        private void heapify(int idx) {
            int left = 2 * idx + 1;
            int right = 2 * idx + 2;
            int minIdx = idx;

            // leafchild < arrSize && parent > leftchild
            if (left < arr.size() && arr.get(minIdx) > arr.get(left)) {
                minIdx = left;
            }

            // leafchild < arrSize && parent > rightchild
            if (right < arr.size() && arr.get(minIdx) > arr.get(right)) {
                minIdx = right;
            }

            // if minIdx value change then swap
            if (minIdx != idx) {
                int temp = arr.get(idx);
                arr.set(idx, arr.get(minIdx));
                arr.set(minIdx, temp);

                // if due to this below child are disturb are fix
                heapify(minIdx);
            }

        }

        // O(logn)
        public int remove() {
            int data = arr.get(0);

            // Step1 - swap 1st and last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            // Step2 - remove last index
            arr.remove(arr.size() - 1);

            // Step3 - heapify
            heapify(0);

            return data;
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }

    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);

        while (!h.isEmpty()) {
            System.out.println(h.peek());
            h.remove();
        }
    }
}
