package JavaBasicPracticeQuestions;


/*
Write a program that will generate 10 random numbers between 1 and 1000. Your program will  display this number to
the console and then inform the user whether it is a prime number or  not.

 */
public class Q4 {
    public static void main(String[] args) {
        int[] numbers = new int[10];

        for (int i = 0; i < 10; i++) {
            numbers[i] = (int) (Math.random() * 1000) + 1;
            boolean flag = false;

            for (int j = 2; j <= numbers[i] / 2; j++) {
                if (numbers[i] % j == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.println(numbers[i] + " is a prime number");
            }
        }
    }
}
