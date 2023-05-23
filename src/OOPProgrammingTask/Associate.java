package OOPProgrammingTask;

public class Associate extends Employee {
    private int hourly;

    public Associate(String first, String last, int hourlyPay) {
        super(first, last);
        hourly = hourlyPay;
    }

    /**
     * Returns the total pay for an Associate
     * @param hours
     * @return
     */
    public int pay(int hours) {
        return hourly * hours;
    }
}
