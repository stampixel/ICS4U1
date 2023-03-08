package Recursion;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(6));
    }

    /**
     * Stack is created first, then is slowly shrunken down again
     * f(1) --> 1 --> return 1
     * f(2) --> 2 * 1 = 2
     * f(3) --> 3 * 2 = 6
     * f(4) --> 6 * 4 = 24
     * f(5) --> 24 * 5 = 120
     * f(6) --> 120 * 6 = 720
     * returns the number to the original call
     *
     * Calling, built it up to 1, and then we figure out the math as the stack is being popped from top-down
     * @param num
     * @return
     */
    public static int factorial(int num) {
        if (num >= 1) {
            return num * factorial(num - 1);
        } else {
            return 1;
        }
    }
}
