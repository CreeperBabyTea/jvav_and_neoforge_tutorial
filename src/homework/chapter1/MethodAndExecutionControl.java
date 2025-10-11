package homework.chapter1;

public class MethodAndExecutionControl {
    public static void printMultiplicativeTable() {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.println(i + "*" + j + "=" + i * j);
            }
        }
    }

    public static void sortGrades(int score) {
        if (score < 0 || score > 100) {
            System.out.println("Invalid score: " + score);
        } else {
            System.out.print("Grade of " + score + ": ");   //System.out.print()不换行
            if (score > 85) {
                System.out.println("A");
            } else if (score > 70) {
                System.out.println("B");
            } else if (score > 60) {
                System.out.println("C");
            } else
                System.out.println("D");
        }
    }

    public static void main(String[] args) {
        System.out.println("Multiplicative table: ");
        printMultiplicativeTable();
        sortGrades(105);
        sortGrades(98);
        sortGrades(84);
    }
}
