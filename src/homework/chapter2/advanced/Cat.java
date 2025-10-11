package homework.chapter2.advanced;

public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void onHungry() {
        System.out.println("Hunting!");
    }
}
