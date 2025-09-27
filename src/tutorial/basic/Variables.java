package tutorial.basic;

public class Variables {
    public static void main(String[] args) {
        int a = 1;
        int b;
        b = 3;

        System.out.println(a + b);   // 4

        int c, d;

        //System.out.println(c + d);   // 错误，c, d尚未初始化

        c = 1;
        d = 0;

        //System.out.println(c / d);   //编译通过，运行报错，除以零

        final int aFinalInteger = 10;
        //aFinalInteger = 20;   //错误

        final int anotherFinalInteger;
        anotherFinalInteger = 0;
        //anotherFinalInteger = 1;  //错误

        String user1 = "somebody";
        String user2 = new String("somebody");

        System.out.println(user1 == user2);   //false
        System.out.println(user1.equals(user2));   //true

        int[] integerArray = new int[10];
        //float[] floatArray = new float[];   //错误，未指定容量
        char[] dummy = {'d', 'u', 'm', 'm', 'y'};

        int[][] integerVertex = new int[10][];
        int[][] anotherMatrix = {
                new int[3],
                new int[5],
                new int[2]
        };
    }
}
