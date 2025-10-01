package tutorial.oop.basic;

public class Cat {
    public static final String SPECIES = "cat";

    private final String name;
    /**
     * unit: kg
     */
    public int weight = 2;
    /**
     * unit: year
     */
    public int age = 3;

    {
        System.out.println("Initializer Block!");
        Shelter.host(this);
    }

    public Cat(String name) {
        this.name = name;
        System.out.println("Constructor!");
    }

    public Cat() {
        this("wild");
    }

    public String voice() {
        return name + " meowed: nya❤~";
    }

    public static void main(String... args) {
        var nachoneko = new Cat("Amashiro Natsuki");
        System.out.println(nachoneko.voice());
    }

    /* ... */
}
