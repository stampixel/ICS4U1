package Recursion;

public class fibonacci {
    public static void main(String[] args) {
        System.out.println(f(12 - 1));
    }

    public static int f(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return f(n - 2) + f(n - 1);
        }
    }
}
