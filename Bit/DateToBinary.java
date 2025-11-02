package Bit;

public class DateToBinary {
    public static String convertDateToBinary(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));
        StringBuilder sb = new StringBuilder();

        // here .toBinaryString() is method which convert decimal to binary
        sb.append(Integer.toBinaryString(year))
            .append("-")
            .append(Integer.toBinaryString(month))
            .append("-")
            .append(Integer.toBinaryString(day));

        return sb.toString();
    }

    public String convertDateToBinary2(String date) {
        StringBuilder ans = new StringBuilder("");
        String[] parts = date.split("-");
        for(int i=0; i<parts.length; i++) {
            String curr = DecBin(parts[i]);
            if(i != parts.length-1) {
                ans.append(curr);
                ans.append("-");
            } else {
                ans.append(curr);
            }
        }
        return ans.toString();
    }

    public String DecBin(String str) {
        long n = Long.parseLong(str);
        if (n == 0) return "0";

        StringBuilder bin = new StringBuilder();
        while (n > 0) {
            long rem = n % 2;
            bin.append(rem);
            n = n / 2;
        }
        return bin.reverse().toString();
    }

    public static void main(String[] args) {
        String date = "2003-10-23";
        System.out.println(convertDateToBinary(date));
    }
}
