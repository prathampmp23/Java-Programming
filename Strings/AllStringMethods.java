package Strings;

import java.util.Arrays;

public class AllStringMethods {
    public static void main(String[] args) {
        String s = "  Hello World  ";
        String s2 = "Java";
        String s3 = "java";
        String csv = "a,b,c";
        String numStr = "12345";
        String banana = "banana";

        // 1. length()
        System.out.println("Length: " + s.length()); // 15 (includes spaces)

        // 2. charAt()
        System.out.println("Char at index 2: " + s.charAt(2));

        // 3. substring()
        System.out.println("Substring from index 2: " + s.substring(2));
        System.out.println("Substring from 2 to 7: " + s.substring(2, 7));

        // 4. equals() and equalsIgnoreCase()
        System.out.println("Equals: " + s2.equals(s3)); // false
        System.out.println("Equals Ignore Case: " + s2.equalsIgnoreCase(s3)); // true

        // 5. compareTo() and compareToIgnoreCase()
        System.out.println("CompareTo: " + "apple".compareTo("banana")); // -ve means less
        System.out.println("CompareTo Ignore Case: " + "apple".compareToIgnoreCase("Apple")); // 0

        // 6. contains()
        System.out.println("Contains 'World': " + s.contains("World"));

        // 7. indexOf() and lastIndexOf()
        System.out.println("Index of 'na': " + banana.indexOf("na"));
        System.out.println("Last index of 'na': " + banana.lastIndexOf("na"));

        // 8. isEmpty() and isBlank() (Java 11+)
        System.out.println("Is empty: " + "".isEmpty());
        System.out.println("Is blank: " + "   ".isBlank()); // Java 11+

        // 9. toUpperCase() / toLowerCase()
        System.out.println("Upper case: " + s2.toUpperCase());
        System.out.println("Lower case: " + s2.toLowerCase());

        // 10. trim(), strip(), stripLeading(), stripTrailing()
        System.out.println("Trim: '" + s.trim() + "'");
        System.out.println("Strip: '" + s.strip() + "'"); // Java 11+
        System.out.println("Strip Leading: '" + s.stripLeading() + "'");
        System.out.println("Strip Trailing: '" + s.stripTrailing() + "'");

        // 11. replace(), replaceAll(), replaceFirst()
        System.out.println("Replace a->o: " + banana.replace('a', 'o'));
        System.out.println("ReplaceAll 'na'->'NA': " + banana.replaceAll("na", "NA"));
        System.out.println("ReplaceFirst 'na'->'NA': " + banana.replaceFirst("na", "NA"));

        // 12. split()
        String[] parts = csv.split(",");
        System.out.println("Split CSV: " + Arrays.toString(parts));

        // 13. matches()
        System.out.println("Only digits? " + numStr.matches("\\d+"));

        // 14. join()
        String joined = String.join("-", "2025", "08", "11");
        System.out.println("Joined: " + joined);

        // 15. repeat()
        System.out.println("Repeat: " + s2.repeat(3)); // Java 11+

        // 16. toCharArray()
        char[] chars = s2.toCharArray();
        System.out.println("Char array: " + Arrays.toString(chars));

        // 17. format()
        String formatted = String.format("Name: %s, Age: %d", "John", 25);
        System.out.println("Formatted: " + formatted);

        // 18. valueOf()
        int num = 42;
        String numStr2 = String.valueOf(num);
        System.out.println("ValueOf int: " + numStr2);

        // 19. intern()
        String str1 = new String("Hello").intern();
        String str2 = "Hello";
        System.out.println("Intern equals: " + (str1 == str2)); // true

        // 20. codePointAt()
        System.out.println("CodePointAt: " + "😊".codePointAt(0));

        // 21. codePoints() - Java 8 stream of Unicode points
        "Hi".codePoints().forEach(cp -> System.out.print(cp + " "));
    }
}
