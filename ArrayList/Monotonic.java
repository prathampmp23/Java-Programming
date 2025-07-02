package ArrayList;

import java.util.ArrayList;

public class Monotonic {
    public static boolean isMonotoinic(ArrayList<Integer> m) {
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 0; i < m.size() - 1; i++) {
            if (m.get(i) > m.get(i + 1)) {
                increasing = false;
            }
            if (m.get(i) < m.get(i + 1)) {
                decreasing = false;
            }
        }
        return increasing || decreasing;
    }

    public static void main(String args[]) {
        ArrayList<Integer> m = new ArrayList<>();
        m.add(1);
        m.add(2);
        m.add(2);
        m.add(3);
        System.out.println(isMonotoinic(m));
    }
}
