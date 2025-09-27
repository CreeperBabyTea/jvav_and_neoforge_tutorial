package tutorial.basic.structure;

import tutorial.basic.structure.client.EventHandler;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class SimpleClass {
    /**
     *
     */
    public static final int A_INTEGER = 200;
    @SuppressWarnings({"all"})
    protected final List someList = new ArrayList();
    private String someString;

    public SimpleClass(String someString) {
        this.someString = someString;
        new SimpleClass("zzzzz");
    }

    /*  一个多行注释 */

    public String getSomeString() {
        return someString;
    }

    //这里有一个单行注释 asdblakjgdflkjagvfbkjawgsf

    /**
     * 这里对方法add进行注释。{@link Integer}
     *
     * @param a 一个形参
     * @see Integer
     */
    @Deprecated
    public static int add(int a) {
        int dummy = ++a;  //单行注释可以放在任何地方
        System.out.println("Now we have " + dummy);
        return dummy;
    }

    public static void main(String[] args) {
        SimpleClass instance = new SimpleClass("zzz");
        instance.getSomeString();
        System.out.println(instance.someString);
    }
}