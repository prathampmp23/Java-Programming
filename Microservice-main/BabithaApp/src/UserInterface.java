import java.util.*;

public class UserInterface {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the paragraph typed");
        String paragraph = sc.nextLine();

        String[] words = paragraph.split("[,;:.?!@#$%\\s]+");

        Map<String, Integer> map = new HashMap<>();
        List<String> list;

        int totalWordCount = 0;

        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }
            String lower = word.toLowerCase();
            map.put(lower, map.getOrDefault(lower, 0) + 1);
            totalWordCount++;
        }

        list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        System.out.println("Total number of words " + totalWordCount);
        System.out.println("Words with the count");

        for (String key : list) {
            System.out.println(key + " - " + map.get(key));
        }

        sc.close();
    }
}