package tutorial.oop.special;

public enum EnumWithArgsDemo {
    A(1),
    B(2),
    C(3);

    public final int value;

    EnumWithArgsDemo(int value) {
        this.value = value;
    }

    public static void main(String[] args) {
        System.out.println(A.value);
    }
}
