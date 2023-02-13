package JavaBasicPracticeQuestions;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Hi! How many donuts would you like?");

        int donutsAmount = scan.nextInt();
        double total;
        if (donutsAmount < 72) {
            double value1 = 8.99;
            double lessThanSix = value1 / 12;
            total = donutsAmount * lessThanSix;
        } else if (donutsAmount < 144) {
            double value2 = 7.99;
            double lessThanTwelve = value2 / 12;
            total = donutsAmount * lessThanTwelve;
        } else if (donutsAmount < 192) {
            double value3 = 6.99;
            double lessThanSixteen = value3 / 12;
            total = donutsAmount * lessThanSixteen;
        } else {
            double value4 = 5.99;
            double moreThanSixteen = value4 / 12;
            total = donutsAmount * moreThanSixteen;
        }
        System.out.println("Your total is:" + total);
    }
}
