package com.junit.codes;

public class ReverseStr {

    // abc => cba
    public String reverse(String s) {
        int left = 0;
        int right = s.length() - 1;
        char charArray[] = s.toCharArray();

        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }
        return new String(charArray);
    }

    public static void main(String[] args) {
        ReverseStr s = new ReverseStr();
        String actual = "abc";
        String expected = s.reverse(actual);
        System.out.println(expected);  
    }
}
