package homework.chapter2.advanced;

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
        if (weight > 0)
            this.weight = weight;
    }

    public void age() {
        this.age++;
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

    public void onHungry() {
        System.out.println("I'm hungry!");
    }
}
