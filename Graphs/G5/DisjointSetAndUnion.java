package Graphs.G5;

public class DisjointSetAndUnion {
    static int n = 7;
    static int parent[] = new int[n];
    static int rank[] = new int[n];

    public static void init() {
        for (int i = 0; i < parent.length; i++) {
            // at the begining all parents is parent of itself
            parent[i] = i;
        }
    }

    // find function 
    // T.c = O(4K) where k = constant (most optimize)
    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        // path compression 
        return parent[x] = find(parent[x]);
    }

    // union function
    // T.c = O(4K) where k = constant (most optimize)
    public static void union(int a, int b) {
        int parA = find(a); // find leader of a
        int parB = find(b); // find leader of b

        if (rank[parA] == rank[parB]) {
            // here b join with a and thus a make its parent
            parent[parB] = parA;
            rank[parA]++;
        } else if (rank[parA] < rank[parB]) {
            // a join with b
            parent[parA] = parB;
        } else {
            // b join with a
            parent[parB] = parA;
        }
    }

    public static void main(String[] args) {
        init(); // initialize parent
        System.out.println(find(3)); // 3 is 3's leader
        union(1, 3);
        System.out.println(find(3)); // now 1 is 3's leader
        union(2, 4);
        union(3, 6);
        union(1, 4);
        System.out.println(find(3)); // now 1 is 3's leader
        System.out.println(find(4)); // now 1 is 2's leader and 2 is 4's leader
        union(1, 5);
    }
}
