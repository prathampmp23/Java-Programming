package Core;

// class Holdes only data (data carring class)
// class Alien {
//     private int id;
//     private String name;

//     public Alien(int id, String name) {
//         this.id = id;
//         this.name = name;
//     }

//     public int getId() {
//         return id;
//     }

//     public String getName() {
//         return name;
//     }

//     @Override
//     public int hashCode() {
//         final int prime = 31;
//         int result = 1;
//         result = prime * result + id;
//         result = prime * result + ((name == null) ? 0 : name.hashCode());
//         return result;
//     }

//     @Override
//     public boolean equals(Object obj) {
//         if (this == obj)
//             return true;
//         if (obj == null)
//             return false;
//         if (getClass() != obj.getClass())
//             return false;
//         Alien other = (Alien) obj;
//         if (id != other.id)
//             return false;
//         if (name == null) {
//             if (other.name != null)
//                 return false;
//         } else if (!name.equals(other.name))
//             return false;
//         return true;
//     }

//     @Override
//     public String toString() {
//         return "Alien [id=" + id + ", name=" + name + "]";
//     }
// }

// above commented code in single line
// using "Record Classes" - 
// we can't set any record variable value when stored as the main purpose is to store (record data)
record Alien(int id, String name) { // it is a canonical constructor (id, name is state parameters)
}

public class RecordClasses {
    public static void main(String[] args) {
        Alien a = new Alien(1, "Pratham");
        Alien b = new Alien(2, "Rishabh");
        Alien c = new Alien(1, "Pratham");
        System.out.println(a);
        // instead of this in record
        // System.out.println(a.getName());
        // System.out.println(b.getName());

        // use variable name as method name
        System.err.println(a.id()); 
        System.err.println(a.name());

        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
    }
}
