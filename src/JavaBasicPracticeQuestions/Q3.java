package JavaBasicPracticeQuestions;

import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        int sum = num;
        int increment = 0;

        if (num % 2 == 0) {
            sum += 1;
        } else {
            sum += 2;
        }
        increment = sum;


        for (int i = 0; i < 5; i++) {
            sum += increment;
            increment += 2;
            System.out.println(increment);
        }

        System.out.println(sum-1);
    }
}
