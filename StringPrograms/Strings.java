package StringPrograms;

public class Strings {
        public static void main(String args[]){

            //String declaration method
            String str = "Pratham";
            String str1 = new String("Potdar");
            System.out.println(str);
            System.out.println(str1);

            //concatenation
            String Firstname ="Pratham";
            String Lastname ="Potdar";
            String Fullname = Firstname + " " + Lastname;
            System.out.println(Fullname+" is the fullname.");

            //to get String length
            //which include blankspace also
            System.out.println(Fullname.length());

            //to get character at any position we use charAt() method
            System.out.println(Fullname.charAt(0));
        }
    }