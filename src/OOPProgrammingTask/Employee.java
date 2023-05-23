package OOPProgrammingTask;

public abstract class Employee {
    private String firstName;
    private String lastName;
    private int salary;

    public Employee(String first, String last) {
        firstName = first;
        lastName = last;
    }

    public Employee(String first, String last, int yearlySalary) {
        firstName = first;
        lastName = last;
        salary = yearlySalary;
    }

    /**
     * Getters
     */
    public String getFirstName() {
        return firstName;
    }
    public String getLastNAme() {
        return lastName;
    }
    /**
     * Setters/Mutators
     */
    public void setFirstName(String name) {
        firstName = name;
    }
    public void setLastName(String name) {
        lastName = name;
    }

    /**
     * Helpers
     */
    public int pay(int years) {
        return salary*years;
    }
}

