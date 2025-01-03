package Z_Practice;
public class StringMethod {
    public static void main(String[] args) {
        // String methods
        String name = "Pratham Mansish Potdar";
        System.out.println(name.toUpperCase());
        System.out.println(name.toLowerCase());
        System.out.println(name.trim());
        System.out.println(name.startsWith("P"));
        System.out.println(name.endsWith("am"));
        System.out.println(name.equals("Pratham"));
        System.out.println(name.equalsIgnoreCase("PRATHAM"));
        System.out.println(name.charAt(0)); // return char at index 0

        // knowledge of converting int to string
        int age = 21;
        String stringAge = String.valueOf(age);
        System.out.println(stringAge);

        System.out.println(name.replace(name, "Developer"));
        System.out.println(name.contains("P"));
        System.out.println(name.substring(0, 5));
        System.out.println(name.substring(7));

        String words[] = name.split(" ");
        for (String word : words) {
            System.out.println(word);
        }

        char letters[] = name.toCharArray();
        for (char letter : letters) {
            System.out.println(letter);
        }
        
        System.out.println(name.isEmpty());
    }
}