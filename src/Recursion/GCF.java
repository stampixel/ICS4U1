package Recursion;

public class GCF {
    /**
     * Accept two integer values and using the Euclid’s method find the greatest common factor and return that value.
     * Task: Prompt the user to enter 2 numbers (ints) and call a recursive method that returns the GCF(passing the
     * two numbers as parameters ) and output the greatest common factor in good format.
     * Use the Rules:
     * Rule 1 if (m=n) then gcf (m,n) = m
     * Rule 2 if (m>n) then gcf (m,n) = gcf (n, m-n)
     * Rule 3 if (m<n) then gcf (m,n) = gcf (n, m)
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(gcf(12, 24));
    }

    public static int gcf(int m, int n) {
        if (m == n) {
            return m;
        }
        if (m > n) {
            return gcf(n, m - n);
        } else {
            return gcf(n, m);
        }
    }
}
