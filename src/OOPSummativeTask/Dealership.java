package OOPSummativeTask;

import java.util.Scanner;

/**
 * @author Kevin Tang
 * 2023.05.23
 */

public class Dealership {
    public static void main(String[] args) {
        // Dealership array which is composed of Vehicles
        Vehicle[] dealership = {new ATV(2018, "Yamaha", "Kodiak 700", 12000), new Motorcycle(2023, "Yamaha", "FJR 1300", 22000), new Motorcycle(2018, "Honda", "GL 1800", 27000)};
        Scanner scan = new Scanner(System.in);
        String choice = "";
        int vehicleChoice;


        System.out.println("Hi there, welcome to the dealership.");

        while (true) {
            System.out.println();
            System.out.println("""
                    V. Vehicle
                    P. Price
                    Q. Quit""");
            System.out.print("Enter choice: ");
            choice = scan.next().toLowerCase(); // Change to lowercase to improve consistency

            if (choice.equals("q")) { // Quit
                break;
            } else if (choice.equals("v")) { // Select a vehicle to print
                System.out.print("Enter vehicle number (1-3): ");
                vehicleChoice = scan.nextInt();

                if (1 > vehicleChoice || vehicleChoice > 3) { // Invalid input
                    System.out.println("Invalid input!");
                } else {
                    System.out.println(dealership[vehicleChoice - 1]); // Since we have a toString method inside the subclass, we are able to directly print and Java will handle the rest
                }

            } else if (choice.equals("p")) { // Select a vehicle to output its price
                System.out.print("Enter vehicle number (1-3): ");
                vehicleChoice = scan.nextInt();

                if (1 > vehicleChoice || vehicleChoice > 3) { // Invalid input
                    System.out.println("Invalid input!");
                } else {
                    dealership[vehicleChoice - 1].printPrice(); // Calling the printPrice method on the vehicle on that specific index
                }
            } else {
                System.out.println("Invalid input!");
            }
        }
    }
}
