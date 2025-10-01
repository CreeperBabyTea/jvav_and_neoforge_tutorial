package tutorial.oop.special;

public record RecordDemo(int integer1, String string1) {  //  record类型，直接声明其全部实例字段
    // public int a;  错误，不允许额外声明实例字段

    public RecordDemo() {
        this(1, "zzz");   //隐式自带构造器，访问为public
        System.out.println(this.integer1());  //隐式的实例方法
        System.out.println(this.string1());
        // this.integer1 = 0;  错误，记录类字段均为final
    }
}
