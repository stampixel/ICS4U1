package Recursion;

public class RecursionExercisesPart2 {
    public static void main(String[] args) {
        System.out.println(ha(0));
        int[] arr = new int[]{1, 2, 3, 4, 5};
        System.out.println(addUp(arr, arr.length - 1));

    }

    public static int ha(int n) {
        if (n < 1) {
            return 0;
        } else {
            System.out.print("Ha");
            return ha(n - 1);
        }
    }

    public static int addUp(int[] array, int len) {
        if (len < 1) {
            return 1;
        } else {
            return array[len] + addUp(array, len - 1);
        }
    }

    public static int f(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return f(n - 2) + f(n - 1);
        }
    }
}
