package Recursion;

public class test {
    public static void main(String[] args) {

        mystery(1234);
        System.out.println();
        System.out.println(product(5));
        System.out.println(f(5));
        System.out.println(redo(82, 3));
        System.out.println(g(4, -2));

        System.out.println(productOfDigits(100));

    }

    public static void mystery(int x) {
        System.out.print(x % 10);
        if ((x / 10) != 0) {
            mystery(x / 10);
        }
        System.out.print(x % 10);
    }

    public static int product(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * product(n - 2);
        }
    }

    public static int f(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return f(n - 1) + f(n - 2);
        }
    }

    public static int redo(int i, int j) {
        if (i == 0) {
            return 0;
        } else {
            return redo(i / j, j) + 1;
        }
    }


    // TEST
    public static int g(int a, int b) {
        if (b < 0) {
            return g(-1 * a, -1 * b);
        } else if (b == 0) {
            return 0;
        } else {
            return a + g(a, b - 1);
        }
    }

    public static int productOfDigits(int num) {
        if (num <= 0) {
            return 1;
        } else {
            return productOfDigits(num / 10) * num % 10;
        }
    }
}
