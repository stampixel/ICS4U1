package OOPSummativeTask;

/**
 * @author Kevin Tang
 * 2023.05.23
 */

public class Motorcycle extends Vehicle {
    /**
     * Using the constructor of the superclass, hence the keyword "super"
     *
     * @param vehicleYear  production year
     * @param vehicleManu  manufacturer
     * @param vehicleModel model
     * @param vehiclePrice price
     */
    public Motorcycle(int vehicleYear, String vehicleManu, String vehicleModel, double vehiclePrice) {
        super(vehicleYear, vehicleManu, vehicleModel, vehiclePrice);
    }

    /*
    Helper Methods
     */

    /**
     * Monthly price of vehicle for 4 years
     *
     * @return
     */
    public double calculatePrice() {
        return getPrice() / 4 / 12;
    }

    /**
     * Void method that prints price
     */
    public void printPrice() {
        System.out.println("$" + (Math.round(calculatePrice() * 100.0) / 100.0) + " per month for four years.");
    }

    /**
     * Feature built into Java, a method named toString inside the class allows the class to directly be printed in a System.out.print.
     *
     * @return
     */
    public String toString() {
        return getYear() + ", " + getManufacturer() + ", " + getModel();
    }
}
