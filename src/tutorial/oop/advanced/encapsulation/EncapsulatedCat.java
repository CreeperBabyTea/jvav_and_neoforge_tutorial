package tutorial.oop.advanced.encapsulation;

public class EncapsulatedCat {
    private final String name;
    /**
     * unit: kg
     */
    public int weight = 2;
    /**
     * unit: year
     */
    public int age = 3;

    public EncapsulatedCat(String name) {
        this.name = name;
        System.out.println("Constructor!");
    }

    public EncapsulatedCat() {
        this("wild");
    }

    public String voice() {
        return name + " meowed: nya❤~";
    }

    public void setWeight(int weight) {
        if (weight > 0)
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
}
