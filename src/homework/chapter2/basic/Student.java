package homework.chapter2.basic;

public class Student {
    public static final String SCHOOL = "SEU";
    private static int nextId = 0;

    public static Student newStudent(String name, Gender gender) {
        return new Student(nextId ++, name, gender);
    }

    public int id;
    public String name;
    public Gender gender;

    public String phoneNumber;

    private Student(int id, String name, Gender gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }
}
