package OOP;

public class Toy {
    String name;
    double cost;
    double sellingPrice;

    /**
     * Default constructor
     */
    public Toy() {
        name = "asd";
        cost = 19.99;
        sellingPrice = 25.00;
    }

    /**
     * Custom constructor
     *
     * @param toyName
     * @param toyCost
     * @param toySellingPrice
     */
    public Toy(String toyName, double toyCost, double toySellingPrice) {
        name = toyName;
        cost = toyCost;
        sellingPrice = toySellingPrice;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }
}