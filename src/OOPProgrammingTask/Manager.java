package OOPProgrammingTask;

public class Manager extends Employee {
    private int weeklySalary;

    public Manager(String first, String last, int weeklyPay) {
        super(first, last);
        weeklySalary = weeklyPay;
    }

    /**
     * Returns the total pay for a manager
     * @param payPeriod amount of times payed in a year
     * @return
     */
    public int pay(int payPeriod) {
        return weeklySalary/payPeriod;
    }
}
