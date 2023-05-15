package OOP;

public class Animal {
    String animal;
    String gender;
    String foodType;
    int age;
    boolean alive;

    public Animal(String animalType, String animalGender, String food, int ageYear, boolean isAlive) {
        animal = animalType;
        gender = animalGender;
        foodType = food;
        age = ageYear;
        alive = isAlive;
    }

    public static void main(String[] args) {
        Animal dog = new Animal("dog", "male", "carnivore", 6, true);
        Animal cat = new Animal("cat", "female", "omnivore", 3, true);

        dog.incrementAge(); // Changing attribute
        System.out.println("This animal object is a " + dog.getType());
    }

    /*
    Accessor methods
     */

    public String getType() {
        return animal;
    }

    public String getGender() {
        return gender;
    }

    public String getFoodType() {
        return foodType;
    }

    public int getAge() {
        return age;
    }

    public boolean getStatus() {
        return alive;
    }


    /*
    Action methods
     */

    public void incrementAge() {
        age++;
    }

    public void die() {
        alive = false;
    }

    public void eat() {
    }

    public void sleep() {
    }

    public void move() {
    }
}
