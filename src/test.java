import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        int[] testArray = {3, 4, 5};

        for (int i = 0; i < testArray.length; i++) {
            increment(testArray[i]);
            System.out.print(testArray[i] + " ");
        }

        for (int element : testArray) {
            increment(element);
            System.out.print(element + " ");
        }


    }

    public static void increment(int n) {
        n++;
    }

}
