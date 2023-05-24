package OOPSummativeTask;

public class ATV extends Vehicle {
    double totalPayed;
    public ATV(int vehicleYear, String vehicleManu, String vehicleModel, double vehiclePrice) {
        super(vehicleYear, vehicleManu, vehicleModel, vehiclePrice);
    }

    /*
    Helper Methods
     */

    public double calculatePrice() {
        return price * 0.1;
    }
}
