package Recursion;

public class EvenMoreRecursionExcercises {
    public static void main(String[] args) {
        System.out.println(length("kevin"));
        System.out.println(calculateSum(5));
        System.out.println(reverseString("write"));
    }


    public static int length(String word) {
        if (word.equals("")) {
            return 0;
        } else {
            return length(word.substring(1)) + 1;
        }
    }

    public static int calculateSum(int num) {
        if (num <= 0) {
            return 0;
        } else {
            return calculateSum(num - 1) + num;
        }
    }

    public static String reverseString(String word) {
        if (word.length() == 0) {
            return "";
        } else {
            return reverseString(word.substring(1)) + word.charAt(0);
        }
    }
}
