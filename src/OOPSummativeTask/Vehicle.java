package OOPSummativeTask;

/**
 * @author Kevin Tang
 * 2023.05.23
 */

public abstract class Vehicle {
    private int year;
    private String manufacturer;
    private String model;
    private double price;

    /**
     * Constructor, passing the user inputs into the class itself
     *
     * @param vehicleYear
     * @param vehicleManu
     * @param vehicleModel
     * @param vehiclePrice
     */
    public Vehicle(int vehicleYear, String vehicleManu, String vehicleModel, double vehiclePrice) {
        year = vehicleYear;
        manufacturer = vehicleManu;
        model = vehicleModel;
        price = vehiclePrice;
    }

    /*
    Getters/Accessors
    Returns each specified value
     */
    public int getYear() {
        return year;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    /*
    Mutators/Setters
     */

    /**
     * modify the year
     *
     * @param year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * modify the manufacturer
     *
     * @param manufacturer
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * modify the model
     *
     * @param model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * modify the price of vehicle
     *
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /*
    Helper Methods
     */
    public abstract double calculatePrice(); // Calculate the price of the specific vehicle

    public abstract void printPrice(); // Prints price in an appropriate format
}
