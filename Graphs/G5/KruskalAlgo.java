package Graphs.G5;

import java.util.ArrayList;
import java.util.Collections;

public class KruskalAlgo {
    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.wt - e2.wt; // sorting based on acscending order of wt
        }
    }

    public static void createedges(ArrayList<Edge> edges) {

        // store edge info
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));

    }

    static int n = 4; // vertices
    static int parent[] = new int[n];
    static int rank[] = new int[n];

    public static void init() {
        for (int i = 0; i < parent.length; i++) {
            // at the begining all parents is parent of itself
            parent[i] = i;
        }
    }

    // find function
    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        // path compression
        return parent[x] = find(parent[x]);
    }

    // union function
    public static void union(int a, int b) {
        int parA = find(a); // find leader of a
        int parB = find(b); // find leader of b

        if (rank[parA] == rank[parB]) {
            parent[parB] = parA;
            rank[parA]++;
        } else if (rank[parA] < rank[parB]) {
            parent[parA] = parB;
        } else {
            parent[parB] = parA;
        }
    }

    public static void KruskalMST(ArrayList<Edge> edges, int V) {
        init(); // initialize parent
        Collections.sort(edges); // T.c  = O(E logE)
        int mstCost = 0;
        int count = 0;

        // T.c = O(V)
        for (int i = 0; count < V - 1; i++) { 
            Edge e = edges.get(i);

            int parA = find(e.src); // src= = a
            int parB = find(e.dest); // dest = b

            // check cycle condition
            if (parA != parB) { // no cycle exist
                union(e.src, e.dest);
                mstCost += e.wt;
                count++;
            }
        }
        System.out.println(mstCost);
    }

    public static void main(String[] args) {
        int V = 4; // no of vertex

        // Array of Arraylist
        ArrayList<Edge> edges = new ArrayList<>();
        createedges(edges);

        KruskalMST(edges, V);
    }
}
