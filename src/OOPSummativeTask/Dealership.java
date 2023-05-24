package OOPSummativeTask;

import javax.swing.plaf.synth.SynthUI;
import java.util.Scanner;

public class Dealership {
    public static void main(String[] args) {
        /**
         * One ATV,
         * 2018, Yamaha, Kodiak 700, priced at $12,000
         * Two motorcycles
         * 2023, Yamaha, FJR 1300, priced at $22,000
         * 2018, Honda, GL 1800, priced at $27,000
         */

        String choice = "";
        int vehicleChoice;
        Vehicle[] dealership = {new ATV(2018, "Yamaha", "Kodiak 700", 12000), new Motorcycle(2023, "Yamaha", "FJR 1300", 22000), new Motorcycle(2018, "Honda", "GL 1800", 27000)};
        Scanner scan = new Scanner(System.in);

        System.out.println("Hi there, welcome to the dealership.");


        while (true) {

            System.out.println("" +
                    "V. Vehicle" +
                    "P. Price" +
                    "Q. Quit");
            System.out.print("Enter choice: ");
            choice = scan.next().toLowerCase();

            if (choice.equals("q")) {
                break;
            } else if (choice.equals("v")) {
                System.out.println("Enter vehicle number (1-3): ");
                vehicleChoice = scan.nextInt();

            } else if (true) {

            } else {
                System.out.println("Invalid input!");
                continue;
            }





        }

    }
}
