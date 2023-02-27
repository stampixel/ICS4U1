package Review;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileIO1 {
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter write = new PrintWriter("studentinto.txt");
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter student name: ");
            String name = scan.next();

            write.println(name);

            System.out.print("Enter student mark: ");
            int mark = scan.nextInt();

            write.println(mark);
        }
        write.close();
    }
}
