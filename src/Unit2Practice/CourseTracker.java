package Unit2Practice;

import java.util.Scanner;

public class CourseTracker {
    static Scanner scan = new Scanner(System.in);
    static String[] courseCodes = new String[]{"math", "english", "art", "history", "economy", "physics", "chemistry",
            "computer"};

    public static void main(String[] args) {
        int[][] marks = new int[8][2];
        enterMarks(marks);
        showBestSix(marks, "mid");


    }

    public static void enterMarks(int[][] marks) {
        int midterm = 0;
        int finalterm = 0;

        System.out.println("Please enter the midterm and final marks in the specific format: 98 83");
        for (int i = 0; i < marks.length; i++) {
            System.out.print(courseCodes[i] + ": ");
            midterm = scan.nextInt();
            finalterm = scan.nextInt();

            marks[i][0] = midterm;
            marks[i][1] = finalterm;
        }
    }

    /**
     * Will accept the marks 2d array and “mid” or “fin” as parameters. It will then determine the best six courses,
     * display them and the calculated academic average to one decimal place.
     */
    public static void showBestSix(int[][] marks, String term) {
        int termIndex;
        // Sort using bubble sort
        if (term.equals("mid")) {
            termIndex = 0;
        } else {
            termIndex = 1;
        }

        for (int i = 0; i < marks.length - 1; i++) {
            for (int j = 0; j < marks.length - 1 - i; j++) {
                if (marks[j][termIndex] < marks[j + 1][termIndex]) {
                    int temp = marks[j][termIndex];
                    marks[j][termIndex] = marks[j + 1][termIndex];
                    marks[j + 1][termIndex] = temp;

                    String courseTemp = courseCodes[j];
                    courseCodes[j] = courseCodes[j + 1];
                    courseCodes[j + 1] = courseTemp;
                }
            }
        }

        System.out.println("Your top 6 courses are:");
        for (int i = 0; i < 6; i++) {
            System.out.println(courseCodes[i] + ": " + marks[i][termIndex]);
        }

    }
}
