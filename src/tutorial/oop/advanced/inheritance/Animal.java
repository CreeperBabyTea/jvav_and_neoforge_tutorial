package tutorial.oop.advanced.inheritance;

public class Animal {
    private final String name;
    /**
     * unit: kg
     */
    public int weight;
    /**
     * unit: year
     */
    public int age = 3;

    public Animal(String name) {
        this.name = name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void age() {
        this.age ++;
    }

    public int getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
