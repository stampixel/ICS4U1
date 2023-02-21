import java.util.Scanner;

public class Level3aArrayExercises {
    public static void main(String[] args) {

    }

    public static void noDuplicates() {
        Scanner scan = new Scanner(System.in);

        int[] numbers = new int[7];
        boolean duplicate = false;
        int count = 0;

        while (true) {
            int num = scan.nextInt();
            duplicate = false;

            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] == num) {
                    duplicate = true;
                    break;
                }
            }
            if (duplicate == true) {
                continue;
            } else {
                count += 1;
                if (count == 7) {
                    break;
                }
            }
        }
    }

    /**
     * Create a method called randomNoDuplicates which will output 10 unique integers all
     * which fall within a specified range.
     */
    public static void randomNoDuplicates(int min, int max) {


    }
}
