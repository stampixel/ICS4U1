package Recursion;

public class EvenMoreRecursionExcercises {
    public static void main(String[] args) {
        System.out.println(length("kevin"));
    }

    public static int length(String word) {
        if (word.equals("")) {
            return 0;
        } else {
            return length(word.substring(1)) + 1;
        }
    }
}
