package homework.chapter2.advanced;

import homework.chapter2.basic.Gender;

public class Human extends Animal {
    public final Gender gender;
    private String phoneNumber;

    public Human(String name, Gender gender) {
        super(name);
        this.gender = gender;
    }

    @Override
    public void onHungry() {
        System.out.println("饿了，搞点外卖zzz");
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
