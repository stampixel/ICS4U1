package JavaBasicPracticeQuestions;

import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the amount of donuts purchased: ");
        int donuts = scan.nextInt();

        double price;

        if (donuts < 6) {
            price = donuts * 8.99;
        } else if (donuts < 12) {
            price = donuts * 7.99;
        } else if (donuts < 16) {
            price = donuts * 6.99;
        } else {
            price = donuts * 5.99;
        }

        System.out.println("The total cost is: " + price);
    }
}
