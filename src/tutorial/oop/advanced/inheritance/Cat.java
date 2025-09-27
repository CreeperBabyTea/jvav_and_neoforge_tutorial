package tutorial.oop.advanced.inheritance;

public class Cat extends Animal {
    public Cat(String name) {
        super(name);
        this.setSound("nya~");
    }
}
