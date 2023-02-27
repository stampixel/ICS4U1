package Review;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileIO2 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("studentinto.txt");
        Scanner scan = new Scanner(file);

        int count = 0;
        int max_location = 0;
        int max = 0;

        while (scan.hasNext()) {
            scan.next();
            int num = scan.nextInt();
            count += 2;

            if (num > max) {
                max = num;
                max_location = count;
            }
        }
        scan = new Scanner(file);


        String name = "";
        int mark = 0;
        for (int i = 0; i < max_location; i += 2) {
            name = scan.next();
            mark = scan.nextInt();
        }
        System.out.println(name + " with a mark of " + mark);
    }
}
