package Core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class CollectionAPIs {
    // Collection APIs or Collection Framework(concept)
    // Collection (interface)
    // Collections (class)

    public static void main(String[] args) {

        // "Generics" in collections allow you to create reusable, type-safe data
        // structures (like List<String>, Map<Integer, Person>) by specifying the data
        // type they'll hold (e.g., <String>, <Integer>)

        // if we dont write generics like <Integer>
        // but if string is added then it gives Runtime error
        // Collection nums = new ArrayList();

        // By writing generics this gives compile time error
        // if we only want to store and fetch values then use collection
        Collection<Integer> nums = new ArrayList<Integer>();
        nums.add(6);
        nums.add(4);
        nums.add(7);
        nums.add(2);
        System.out.println(nums);

        for (Object n : nums) {
            int num = (Integer) n;
            System.out.println(num);
        }

        // if we want index also then use List
        List<Integer> nums2 = new ArrayList<Integer>();
        nums2.add(6);
        nums2.add(4);
        nums2.add(4);
        nums2.add(7);
        nums2.add(2);
        System.out.println(nums2);
        // get index
        System.out.println("Index = " + nums2.indexOf(4));

        for (int n : nums2) {
            System.out.println(n);
        }

        // if we want distinct element
        // Set<Integer> nums3 = new HashSet<Integer>();

        // if we want "distinct" element and "sorted"
        Set<Integer> nums3 = new TreeSet<Integer>();
        nums3.add(6);
        nums3.add(6);
        nums3.add(4);
        nums3.add(7);
        nums3.add(7);
        nums3.add(2);
        System.out.println(nums3);

        for (int n : nums3) {
            System.out.println(n);
        }

        // To print values using Itertor (Top most interface)
        // Iterator
        // |
        // V
        // Collection

        System.out.println("Iterator Loop");
        Iterator<Integer> values = nums3.iterator();
        while (values.hasNext()) {
            System.out.println(values.next());
        }

        // Map to store key-val pair
        // key Can't be repeated
        // key -> set
        // value -> list
        Map<String, Integer> student = new HashMap<>();
        student.put("Pratham", 99);
        student.put("Rishabh", 95);
        student.put("Manthan", 93);
        student.put("Manthan", 90);
        student.put("Yachin", 94);
        student.put("Ashsish", 91);

        System.out.println(student);
        System.out.println(student.get("Pratham"));

        System.out.println(student.keySet()); // get all keys
        System.out.println(student.values()); // get all values

        System.out.println("Loop on Map = ");
        for (String key : student.keySet()) {
            System.out.println(key + " = " + student.get(key));
        }

        Map<Integer, Integer> Week = new HashMap<>();
        Week.put(01, 99);
        Week.put(02, 95);
        Week.put(03, 93);
        Week.put(04, 90);
        Week.put(05, 94);
        Week.put(06, 91);
        Week.put(07, 94);

        System.out.println(Week);
        System.out.println(Week.keySet()); // get all keys
        System.out.println(Week.values()); // get all values

        for (int key : Week.keySet()) {
            System.out.println(key + " = " + Week.get(key));
        }

        // If we want "syncronized" map use HashTable better with thread
        Map<String, Integer> student2 = new Hashtable<>();
        student2.put("Pratham", 99);
        student2.put("Rishabh", 95);
        student2.put("Manthan", 93);
        student2.put("Manthan", 90);
        student2.put("Yachin", 94);
        student2.put("Ashsish", 91);

        System.out.println(student2);

        // Sorting on Collection
        List<Integer> num = new ArrayList<Integer>();
        num.add(62);
        num.add(41);
        num.add(96);
        num.add(73);
        num.add(28);

        // *** Collections Sorting ***
        System.out.println("Aesc order = ");
        Collections.sort(num); // in asc order (default)
        System.out.println(num);
        System.out.println("Desc order = ");
        Collections.sort(num.reversed()); // in desc order
        System.out.println(num);

        // ** Comparator ***
        // sorting based on custom logic
        // 1. sorting based on lastDigit
        Comparator<Integer> comp = new Comparator<Integer>() {
            public int compare(Integer i, Integer j) {
                if (i % 10 > j % 10)
                    return 1;
                else
                    return -1;
            }
        };

        System.out.println("Aesc order of last digit = ");
        Collections.sort(num, comp);
        System.out.println(num);

        // 2. sorting based on string length
        List<String> str = new ArrayList<>();
        str.add("Prakash");
        str.add("Sunita");
        str.add("Manish");
        str.add("Jayashri");
        str.add("Pratham");
        str.add("Aditya");

        // *** Collections Sorting ***
        System.out.println("Aesc order = ");
        Collections.sort(str); // in asc order (default)
        System.out.println(str);
        System.out.println("Desc order = ");
        Collections.sort(str.reversed()); // in desc order
        System.out.println(str);

        // based on string length
        Comparator<String> comp2 = new Comparator<String>() {
            public int compare(String i, String j) {
                if (i.length() > j.length())
                    return 1;
                else
                    return -1;
            }
        };

        System.out.println("Aesc order of string length = ");
        Collections.sort(str, comp2);
        System.out.println(str);

        List<Students> info = new ArrayList<>();
        info.add(new Students(22, "Pratham"));
        info.add(new Students(23, "Rishabh"));
        info.add(new Students(21, "Manthan"));
        info.add(new Students(21, "Ashish"));
        info.add(new Students(20, "Yachin"));

        System.out.println(info);

        // Sorting based on age
        // if class dont implements Comparator
        // Comparator<Students> comp3 = new Comparator<Students>() {
        //     public int compare(Students i, Students j) {
        //         if (i.age > j.age)
        //             return 1;
        //         else
        //             return -1;
        //     }
        // };

        // lambda Expression --->>>> // Dece order
        Comparator<Students> comp3 = (i, j) -> i.age < j.age ? 1 : -1;
        Collections.sort(info, comp3);
        for (Students stu : info) {
            System.out.println(stu);
        }
        System.out.println();

        // if class use "implement Comaprable" then use compareTo()
        Collections.sort(info);
        for (Students stu : info) {
            System.out.println(stu);
        }
    }
}

class Students implements Comparable<Students> {
    int age;
    String name;

    public Students(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Students [age=" + age + ", name=" + name + "]";
    }

    public int compareTo(Students that) {
        return this.age > that.age ? 1 : -1;
    }
}