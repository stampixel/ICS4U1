package OOPSummativeTask;

public class Motorcycle extends Vehicle {

    public Motorcycle(int vehicleYear, String vehicleManu, String vehicleModel, double vehiclePrice) {
        super(vehicleYear, vehicleManu, vehicleModel, vehiclePrice);
    }

    /*
    Helper Methods
     */
    public double monthlyPayment() {
        return price / 4 / 12;
    }
}
