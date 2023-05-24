package OOPSummativeTask;

/**
 * @author Kevin Tang
 * 2023.05.23
 */

public class ATV extends Vehicle {
    /**
     * Using the constructor of the superclass, hence the keyword "super"
     *
     * @param vehicleYear  production year
     * @param vehicleManu  manufacturer
     * @param vehicleModel model
     * @param vehiclePrice price
     */
    public ATV(int vehicleYear, String vehicleManu, String vehicleModel, double vehiclePrice) {
        super(vehicleYear, vehicleManu, vehicleModel, vehiclePrice);
    }

    /*
    Helper Methods
     */

    /**
     * Calculates actual price of vehicle
     *
     * @return
     */
    public double calculatePrice() {
        return getPrice() * 0.1;
    }

    /**
     * Void method that prints price
     */
    public void printPrice() {
        System.out.println("One time payment of $" + calculatePrice() + ", which is 10% off the original price.");
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
