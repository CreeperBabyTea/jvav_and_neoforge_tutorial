package tutorial.oop.advanced.encapsulation;

import tutorial.oop.basic.Cat;
import tutorial.oop.basic.Shelter;

public class EncapsulatedCat {
    public static final String SPECIES = "cat";

    private final String name;
    private String sound = "nya~";

    {
        System.out.println("Initializer Block!");
    }

    public EncapsulatedCat(String name) {
        this.name = name;
        System.out.println("Constructor!");
    }

    public EncapsulatedCat() {
        this("wild");
    }

    public String voice() {
        return name + ':' + sound;
    }

    //由于我们不希望sound被改变，所以不提供setSound方法。
    public String getSound() {
        return sound;
    }
}
