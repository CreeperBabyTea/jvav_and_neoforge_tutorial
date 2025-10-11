package homework.chapter2.advanced;

import homework.chapter2.basic.Gender;

import java.util.Objects;

public final class Student extends Human {
    private static int nextId = 0;

    public static Student newStudent(String name, Gender gender) {
        return new Student(name, gender, nextId++);
    }

    private final int id;
    /**
     * Unit: Cent.
     * Using float or double may cause error, which is not wanted on things related to money.
     */
    private int remainingCash;   //Initialized to 0, as a member field.
    /**
     * Initial password: 123456.
     */
    private String password = "123456";

    private Student(String name, Gender gender, int id) {
        super(name, gender);
        this.id = id;
    }

    @Override
    public void onHungry() {
        System.out.println("老登爆点金币，没钱吃饭了");
    }

    public int getId() {
        return id;
    }

    /**
     * No getter for password, considering data safety.
     *
     * @param original The original password. You must give correct original password to reset password.
     * @param password The new password. Won't do anything if incorrect password is put in.
     */
    public void setPassword(String original, String password) {
        if (this.password.equals(original))   //As a reference type, use equals() instead of == is better.
            this.password = password;
        else
            System.out.println("Wrong password!");
    }

    public int getRemainingCash(String password) {
        if (this.password.equals(password))   //As a reference type, use equals() instead of == is better.
            return remainingCash;
        else {
            System.out.println("Wrong password!");
            return -1;
        }
    }

    public void deposit(int amount) {
        if (amount > 0)
            this.remainingCash += amount;
        else
            System.out.println("Invalid amount to deposit: " + amount);
    }

    public void pay(String password, int amount) {
        if (amount < 0) {
            System.out.println("Invalid amount to pay: " + amount);
        } else if (!this.password.equals(password)) {
            System.out.println("Wrong password!");
        } else if (remainingCash < amount) {
            System.out.println("Not enough cash for the payment!");
        } else
            remainingCash -= amount;
    }
}
