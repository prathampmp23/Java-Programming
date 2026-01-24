public class Name {
    public static void main(String[] args) {
        // We define the name as a 5-row grid
        String[] pattern = {
                "####  $$$$   ***  %%%%% #    #  @       @",
                "#   # $   $ *   *   #   #    #  @  @ @  @",
                "####  $$$$  *****   #   ######  @   @   @",
                "#     $ $   *   *   #   #    #  @       @",
                "#     $  $  *   *   #   #    #  @       @"
        };

        for (int i = 0; i < pattern.length; i++) {
            for (int j = 0; j < pattern[i].length(); j++) {
                System.out.print(pattern[i].charAt(j));
            }
            System.out.println();
        }
    }
}
