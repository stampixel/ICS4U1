package Recursion;

public class Power {
    public static void main(String[] args) {
        System.out.println(power(2, 8));
    }

    public static double power(int base, int exponent) {
        if (exponent <= 1) {
            return 1;
        } else {
            return base * power(base, exponent - 1);
        }
    }
}
