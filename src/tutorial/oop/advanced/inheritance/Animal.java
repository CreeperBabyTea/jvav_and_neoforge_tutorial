package tutorial.oop.advanced.inheritance;

public class Animal {
    private final String name;
    private String sound;

    public Animal(String name) {
        this.name = name;
    }

    protected void setSound(String sound) {
        this.sound = sound;
    }

    public String getSound() {
        return sound;
    }

    public String voice() {
        return name + ':' + sound;
    }
}
