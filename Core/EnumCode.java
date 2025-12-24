package Core;

enum Status {
    Running, Success, Failed, Pending; // string constants
}

enum Laptop {
    MacBook(3000), Asus(2000), Dell(2500), Hp(3200);

    private int price;

    private Laptop(int price) {
        this.price = price;
    }
    // to get getters and setters with 2 clicks
    // 1.right click -> Source action..
    // 2.click on generate getters and setters

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}

public class EnumCode {
    public static void main(String[] args) {
        Status s = Status.Running;
        System.out.println(s);
        System.out.println(s.ordinal()); // print order no

        Status ss[] = Status.values(); // to get all values
        for (Status status : ss) {
            System.out.println(status + " " + status.ordinal());
        }

        // If else with enum
        if (s == Status.Running) {
            System.out.println("All good!");
        } else if (s == Status.Pending) {
            System.out.println("Please wait!");
        } else if (s == Status.Failed) {
            System.out.println("Please try again!");
        } else {
            System.out.println("Done");
        }

        // Switch
        switch (s) {
            case Running:
                System.out.println("All good!");
                break;
            case Pending:
                System.out.println("Please wait!");
                break;
            case Failed:
                System.out.println("Please try again!");
                break;

            default:
                System.out.println("Done");
                break;
        }

        Laptop lap = Laptop.Asus;
        System.out.println(lap + " " + lap.getPrice());
        lap.setPrice(35000);
        System.out.println(lap + " " + lap.getPrice());

        System.out.println();

        // to get all names and prices
        for (Laptop laps : Laptop.values()) {
            System.out.println(laps + " " + laps.getPrice());
        }
    }
}
