package homework.chapter2.advanced;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void onHungry() {
        super.onHungry();
        System.out.println("Finding my master!");
    }
}
