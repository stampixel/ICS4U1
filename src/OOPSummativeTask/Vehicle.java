package OOPSummativeTask;

public abstract class Vehicle {
    int year;
    String manufacturer;
    String model;
    double price;

    public Vehicle(int vehicleYear, String vehicleManu, String vehicleModel, double vehiclePrice) {
        year = vehicleYear;
        manufacturer = vehicleManu;
        model = vehicleModel;
        price = vehiclePrice;
    }

    /*
    Getters/Accessors
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

    public void setYear(int year) {
        this.year = year;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /*
    Helper Methods
     */
    public abstract double calculatePrice();
}
